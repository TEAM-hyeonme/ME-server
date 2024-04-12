package shop.hyeonme.me.domain.auth.presentation.web.res

import shop.hyeonme.me.common.enums.Role
import java.time.LocalDateTime

data class GetAppleSignInUrlWebResponse(
    val url: String
)
