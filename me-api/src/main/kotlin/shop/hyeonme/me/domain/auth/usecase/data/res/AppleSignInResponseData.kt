package shop.hyeonme.me.domain.auth.usecase.data.res

import shop.hyeonme.me.common.enums.Role
import java.time.LocalDateTime

data class AppleSignInResponseData(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredAt: LocalDateTime,
    val refreshExpiredAt: LocalDateTime,
    val role: Role
)
