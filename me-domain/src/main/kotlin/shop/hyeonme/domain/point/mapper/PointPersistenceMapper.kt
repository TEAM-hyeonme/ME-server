package shop.hyeonme.domain.point.mapper

import shop.hyeonme.domain.coupon.mapper.toEntity
import shop.hyeonme.domain.coupon.mapper.toModel
import shop.hyeonme.domain.point.entity.SavedPointEntity
import shop.hyeonme.domain.point.entity.UsedPointEntity
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.model.UsedPoint

fun SavedPoint.toEntity() = SavedPointEntity(
    id = id,
    amount = amount,
    userId = userId,
    createdAt = createdAt
)

fun SavedPointEntity.toModel() = SavedPoint(
    id = id,
    amount = amount,
    userId = userId,
    createdAt = createdAt
)

fun UsedPoint.toEntity() = UsedPointEntity(
    id = id,
    amount = amount,
    userId = userId,
    coupon = coupon.toEntity(),
    createdAt = createdAt
)

fun UsedPointEntity.toModel() = UsedPoint(
    id = id,
    amount = amount,
    userId = userId,
    coupon = coupon.toModel(),
    createdAt = createdAt
)