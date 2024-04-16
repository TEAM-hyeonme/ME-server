package shop.hyeonme.me.global.jwt

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import shop.hyeonme.me.domain.auth.model.RefreshToken
import shop.hyeonme.me.domain.auth.model.Role
import shop.hyeonme.me.domain.auth.spi.JwtPort
import shop.hyeonme.me.domain.auth.spi.RefreshTokenPort
import shop.hyeonme.me.domain.auth.usecase.data.res.TokenResponseData
import shop.hyeonme.me.global.jwt.properties.JwtProperties
import java.time.LocalDateTime
import java.util.*

@Component
class JwtAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenPort: RefreshTokenPort
) : JwtPort {
    override fun receiveToken(userId: UUID, role: Role): TokenResponseData {
        val accessToken = generatedAccessToken(userId, role)
        val refreshToken = generatedRefreshToken(userId, role)
        val accessTokenExp = LocalDateTime.now().withNano(0).plusSeconds(jwtProperties.accessExp.toLong())
        val refreshTokenExp = LocalDateTime.now().withNano(0).plusSeconds(jwtProperties.refreshExp.toLong())

        return TokenResponseData(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessExpiredAt = accessTokenExp,
            refreshExpiredAt = refreshTokenExp,
            role = role
        )
    }

    private fun generatedAccessToken(userId: UUID, role: Role) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, jwtProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.ACCESS)
            .setId(userId.toString())
            .claim(JwtProperties.ROLE, role.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    private fun generatedRefreshToken(userId: UUID, role: Role): String {
        val refreshToken = Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, jwtProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.REFRESH)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.refreshExp * 1000))
            .compact()

        refreshTokenPort.saveRefreshToken(
            RefreshToken(
                token = refreshToken,
                userId = userId
            )
        )

        return refreshToken
    }
}