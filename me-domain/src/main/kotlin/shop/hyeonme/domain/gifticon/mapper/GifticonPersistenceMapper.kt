package shop.hyeonme.domain.gifticon.mapper

import shop.hyeonme.domain.gifticon.entity.GifticonEntity
import shop.hyeonme.domain.gifticon.model.Gifticon

fun Gifticon.toDomain() = GifticonEntity(
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