package shop.hyeonme.domain.gifticon.mapper

import shop.hyeonme.domain.gifticon.entity.GifticonEntity
import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.gifticon.model.GifticonInfo
import shop.hyeonme.domain.gifticon.projection.GifticonInfoProjectionData

fun Gifticon.toEntity() = GifticonEntity(
    id = id,
    name = name,
    point = point,
    notice = notice,
    brand = brand,
    profileUrl = profileUrl
)

fun GifticonEntity.toModel() = Gifticon(
    id = id,
    name = name,
    point = point,
    notice = notice,
    brand = brand,
    profileUrl = profileUrl
)

fun GifticonInfoProjectionData.toModel() = Gifticon(
    id = id,
    name = name,
    point = point,
    notice = notice,
    brand = brand,
    profileUrl = profileUrl
)

fun List<GifticonInfoProjectionData>.toModels() = map(GifticonInfoProjectionData::toModel)