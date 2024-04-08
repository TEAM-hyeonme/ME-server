package shop.hyeonme.me.domain.auth.presentation.web.req

import javax.validation.constraints.NotBlank

data class AppleSignInWebRequest(
    @field:NotBlank
    val token: String
)