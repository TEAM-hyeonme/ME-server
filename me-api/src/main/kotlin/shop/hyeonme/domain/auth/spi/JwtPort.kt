package shop.hyeonme.domain.auth.spi

import io.jsonwebtoken.Claims
import shop.hyeonme.domain.auth.model.Role
import shop.hyeonme.domain.auth.usecase.data.res.TokenResponseData
import java.security.PublicKey
import java.util.*

interface JwtPort {
    fun receiveToken(userId: UUID, role: Role): TokenResponseData

    fun getParseHeaders(token: String): Map<String, String>
    fun getClaims(token: String, publicKey: PublicKey): Claims
}