package shop.hyeonme.global.jwt

import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import shop.hyeonme.global.exception.ExpiredTokenException
import shop.hyeonme.global.exception.InternalServerException
import shop.hyeonme.global.exception.InvalidTokenException
import shop.hyeonme.global.jwt.properties.JwtProperties
import shop.hyeonme.global.security.principal.AuthDetailsService
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenParser(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {
    fun parseAccessToken(request: HttpServletRequest): String? =
        request.getHeader(JwtProperties.HEADER)
            .let { it ?: return null }
            .let { if (it.startsWith(JwtProperties.PREFIX))
                it.replace(JwtProperties.PREFIX, "")
            else null }

    fun parseRefreshToken(refreshToken: String): String? =
        if (refreshToken.startsWith(JwtProperties.PREFIX))
            refreshToken.replace(JwtProperties.PREFIX, "")
        else null

    fun authentication(accessToken: String): Authentication =
        authDetailsService.loadUserByUsername(getTokenBody(accessToken, jwtProperties.secretKey).subject)
            .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    private fun getTokenBody(token: String, secret: String): Claims =
        try {
            Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException("토큰이 만료되었습니다.")
                is InvalidClaimException -> throw InvalidTokenException("유효하지 않은 토큰입니다.")
                is JwtException -> throw InvalidTokenException("유효하지 않은 토큰입니다.")
                else -> throw InternalServerException("Server Error")
            }
        }
}