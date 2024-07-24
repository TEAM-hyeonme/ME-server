package shop.hyeonme.domain.gifticon.mapper

import shop.hyeonme.domain.gifticon.presentation.web.req.CreateGifticonWebRequest
import shop.hyeonme.domain.gifticon.usecase.data.req.CreateGifticonRequestData

fun CreateGifticonWebRequest.toRequest() = CreateGifticonRequestData(
    name = name,
    brand = brand,
    profileUrl = profileUrl,
    notice = notice,
    point = point,
)