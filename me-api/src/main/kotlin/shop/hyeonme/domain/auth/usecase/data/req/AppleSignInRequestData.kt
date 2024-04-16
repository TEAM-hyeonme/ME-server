package shop.hyeonme.domain.auth.usecase.data.req

import java.util.Objects

data class AppleSignInRequestData(
    val id: String,
    val user: Objects?
)