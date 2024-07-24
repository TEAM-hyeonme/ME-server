package shop.hyeonme.domain.gifticon.mapper

import shop.hyeonme.domain.gifticon.presentation.web.req.CreateGifticonWebRequest
import shop.hyeonme.domain.gifticon.presentation.web.res.CreateGifticonWebResponse
import shop.hyeonme.domain.gifticon.usecase.data.req.CreateGifticonRequestData
import shop.hyeonme.domain.gifticon.usecase.data.res.CreateGifticonResponseData

fun CreateGifticonWebRequest.toRequest() = CreateGifticonRequestData(
    name = name,
    brand = brand,
    profileUrl = profileUrl,
    notice = notice,
    point = point,
)

fun CreateGifticonResponseData.toResponse() = CreateGifticonWebResponse(
    id = id
)