package shop.hyeonme.global.jwt

import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
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
            .run { if (startsWith(JwtProperties.PREFIX)) replace(JwtProperties.PREFIX, "") else null }
    fun authentication(accessToken: String): Authentication {
        val claims = getClaims(accessToken)

        if(claims.header[Header.JWT_TYPE] != JwtProperties.ACCESS)
            throw throw InvalidTokenException("유효하지 않은 토큰입니다.")

        val userDetails = getDetails(claims.body)

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when(e) {
                is ExpiredJwtException -> throw ExpiredTokenException("토큰이 만료되었습니다.")
                is InvalidClaimException -> throw InvalidTokenException("유효하지 않은 토큰입니다.")
                is JwtException -> throw InvalidTokenException("유효하지 않은 토큰입니다.")
                else -> throw InternalServerException("Server Error")
            }
        }
    }

    private fun getDetails(body: Claims): UserDetails {
        val role = body[JwtProperties.ROLE, String::class.java]
        return authDetailsService.loadUserByUsername(body.id)
    }
}