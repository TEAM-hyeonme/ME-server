package shop.hyeonme.domain.gifticon.mapper

import shop.hyeonme.domain.gifticon.presentation.web.req.CreateGifticonWebRequest
import shop.hyeonme.domain.gifticon.presentation.web.res.CreateGifticonWebResponse
import shop.hyeonme.domain.gifticon.presentation.web.res.QueryGifticonDetailsWebResponse
import shop.hyeonme.domain.gifticon.presentation.web.res.QueryGifticonWebResponse
import shop.hyeonme.domain.gifticon.presentation.web.res.QueryGifticonsWebResponse
import shop.hyeonme.domain.gifticon.usecase.data.req.CreateGifticonRequestData
import shop.hyeonme.domain.gifticon.usecase.data.res.CreateGifticonResponseData
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonDetailsResponseData
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonResponseData
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonsResponseData

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

fun QueryGifticonsResponseData.toResponse() = QueryGifticonsWebResponse(
    gifticons = gifticons.map(QueryGifticonResponseData::toResponse)
)

fun QueryGifticonResponseData.toResponse() = QueryGifticonWebResponse(
    id = id,
    name = name,
    brand = brand,
    profileUrl = profileUrl,
    point = point,
    inventory = inventory
)

fun QueryGifticonDetailsResponseData.toResponse() = QueryGifticonDetailsWebResponse(
    name = name,
    brand = brand,
    profileUrl = profileUrl,
    point = point,
    inventory = inventory,
    notice = notice
)