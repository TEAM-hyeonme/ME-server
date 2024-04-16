package shop.hyeonme.me.domain.auth.model

import java.util.UUID

data class RefreshToken(
    val token: String,
    val userId: UUID
)
