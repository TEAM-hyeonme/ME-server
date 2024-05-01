package shop.hyeonme.domain.auth.usecase.data.res

import shop.hyeonme.domain.auth.model.enums.Role
import java.time.LocalDateTime

data class TokenResponseData(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredAt: LocalDateTime,
    val refreshExpiredAt: LocalDateTime,
    val role: Role
)
