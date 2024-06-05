package shop.hyeonme.domain.user.presentation.data.res

import shop.hyeonme.domain.auth.model.enums.Role

data class QueryMyPageWebResponse (
    val name: String,
    val point: Int,
    val role: Role
)