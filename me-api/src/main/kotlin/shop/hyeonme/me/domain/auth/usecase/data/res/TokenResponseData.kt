package shop.hyeonme.me.domain.auth.usecase.data.res

import shop.hyeonme.me.domain.auth.model.Role
import java.time.LocalDateTime

data class TokenResponseData(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredAt: LocalDateTime,
    val refreshExpiredAt: LocalDateTime,
    val role: Role
)
