package shop.hyeonme.domain.point.mapper

import shop.hyeonme.domain.point.entity.PointEntity
import shop.hyeonme.domain.point.entity.SavedPointEntity
import shop.hyeonme.domain.point.entity.UsedPointEntity
import shop.hyeonme.domain.point.model.Point
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.model.UsedPoint

fun Point.toEntity() = PointEntity(
    id = id,
    userId = userId
)

fun PointEntity.toModel() = Point(
    id = id,
    userId = userId
)

fun SavedPoint.toEntity() = SavedPointEntity(
    id = id,
    amount = amount,
    point = point.toEntity(),
    createdAt = createdAt
)

fun SavedPointEntity.toModel() = SavedPoint(
    id = id,
    amount = amount,
    point = point.toModel(),
    createdAt = createdAt
)

fun UsedPoint.toEntity() = UsedPointEntity(
    id = id,
    amount = amount,
    point = point.toEntity(),
    createdAt = createdAt
)

fun UsedPointEntity.toModel() = UsedPoint(
    id = id,
    amount = amount,
    point = point.toModel(),
    createdAt = createdAt
)