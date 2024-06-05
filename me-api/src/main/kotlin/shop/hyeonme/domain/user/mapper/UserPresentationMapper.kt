package shop.hyeonme.domain.user.mapper

import shop.hyeonme.domain.user.presentation.data.res.QueryMyPageWebResponse
import shop.hyeonme.domain.user.usecase.data.res.QueryMyPageResponseData

fun QueryMyPageResponseData.toResponse(): QueryMyPageWebResponse =
    QueryMyPageWebResponse(
        name = name,
        point = point,
        role = role
    )