package shop.hyeonme.domain.auth.presentation.web.req

import javax.validation.constraints.NotBlank

data class AppleSignInWebRequest(
    @field:NotBlank
    val id_token: String,
    val user: String?
)