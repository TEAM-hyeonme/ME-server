package shop.hyeonme.domain.user.model

import shop.hyeonme.domain.auth.model.Role
import java.util.*

data class User(
    val id: UUID = UUID(0, 0),
    val name: String,
    val role: Role,
    val email: String
)