package shop.hyeonme.domain.user.usecase.data.res

import shop.hyeonme.domain.auth.model.enums.Role

data class QueryMyPageResponseData (
    val name: String,
    val point: Int,
    val role: Role
)