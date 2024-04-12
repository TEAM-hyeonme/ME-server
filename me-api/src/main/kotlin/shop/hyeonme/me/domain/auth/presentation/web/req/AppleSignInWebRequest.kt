package shop.hyeonme.me.domain.auth.presentation.web.req

import java.util.*
import javax.validation.constraints.NotBlank

data class AppleSignInWebRequest(
    @field:NotBlank
    val id: String,
    val user: Objects?
)