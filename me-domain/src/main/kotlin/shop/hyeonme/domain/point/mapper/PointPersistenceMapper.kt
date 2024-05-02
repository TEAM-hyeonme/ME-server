package shop.hyeonme.domain.point.mapper

import shop.hyeonme.domain.exercise.mapper.toEntity
import shop.hyeonme.domain.exercise.mapper.toModel
import shop.hyeonme.domain.order.mapper.toEntity
import shop.hyeonme.domain.order.mapper.toModel
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
    exercise = exercise.toEntity(),
    createdAt = createdAt
)

fun SavedPointEntity.toModel() = SavedPoint(
    id = id,
    amount = amount,
    point = point.toModel(),
    exercise = exercise.toModel(),
    createdAt = createdAt
)

fun UsedPoint.toEntity() = UsedPointEntity(
    id = id,
    amount = amount,
    point = point.toEntity(),
    order = order.toEntity(),
    createdAt = createdAt
)

fun UsedPointEntity.toModel() = UsedPoint(
    id = id,
    amount = amount,
    point = point.toModel(),
    order = order.toModel(),
    createdAt = createdAt
)