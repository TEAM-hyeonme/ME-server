package shop.hyeonme.me.domain.auth.presentation.web.res

import shop.hyeonme.me.domain.auth.model.Role
import java.time.LocalDateTime

data class TokenWebResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredAt: LocalDateTime,
    val refreshExpiredAt: LocalDateTime,
    val role: Role
)
