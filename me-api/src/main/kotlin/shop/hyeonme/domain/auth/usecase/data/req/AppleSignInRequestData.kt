package shop.hyeonme.domain.auth.usecase.data.req

import kotlinx.serialization.Serializable

data class AppleSignInRequestData(
    val idToken: String,
    val user: User?
)

@Serializable
data class User(
    val name: Name,
    val email: String
)

@Serializable
data class Name(
    val firstName: String,
    val lastName: String
)