package shop.hyeonme.global.jwt

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import shop.hyeonme.domain.auth.model.RefreshToken
import shop.hyeonme.domain.auth.model.Role
import shop.hyeonme.domain.auth.spi.JwtPort
import shop.hyeonme.domain.auth.spi.RefreshTokenPort
import shop.hyeonme.domain.auth.usecase.data.res.TokenResponseData
import shop.hyeonme.global.jwt.properties.JwtProperties
import java.security.PublicKey
import java.time.LocalDateTime
import java.util.*

@Component
class JwtAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenPort: RefreshTokenPort,
    private val objectMapper: ObjectMapper
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

    override fun getParseHeaders(token: String): Map<String, String> {
        try {
            val encodedHeader = token.split(".")[0]
            val decodedHeader = String(Base64.getUrlDecoder().decode(encodedHeader))

            val mapType = objectMapper.typeFactory.constructMapType(Map::class.java, String::class.java, Any::class.java)
            return objectMapper.readValue(decodedHeader, mapType) as Map<String, String>
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }

    override fun getClaims(token: String, publicKey: PublicKey): Claims {
        try {
            return Jwts
                .parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .body
        } catch (e: java.lang.Exception) {
            throw java.lang.IllegalArgumentException()
        }
    }
}