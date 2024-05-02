package shop.hyeonme.domain.point.mapper

import shop.hyeonme.domain.exercise.mapper.toEntity
import shop.hyeonme.domain.exercise.mapper.toModel
import shop.hyeonme.domain.purchase.mapper.toEntity
import shop.hyeonme.domain.purchase.mapper.toModel
import shop.hyeonme.domain.point.entity.TotalPointEntity
import shop.hyeonme.domain.point.entity.SavedPointEntity
import shop.hyeonme.domain.point.entity.UsedPointEntity
import shop.hyeonme.domain.point.model.TotalPoint
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.model.UsedPoint

fun TotalPoint.toEntity() = TotalPointEntity(
    id = id,
    userId = userId
)

fun TotalPointEntity.toModel() = TotalPoint(
    id = id,
    userId = userId
)

fun SavedPoint.toEntity() = SavedPointEntity(
    id = id,
    amount = amount,
    totalPoint = totalPoint.toEntity(),
    exercise = exercise.toEntity(),
    createdAt = createdAt
)

fun SavedPointEntity.toModel() = SavedPoint(
    id = id,
    amount = amount,
    totalPoint = totalPoint.toModel(),
    exercise = exercise.toModel(),
    createdAt = createdAt
)

fun UsedPoint.toEntity() = UsedPointEntity(
    id = id,
    amount = amount,
    totalPoint = totalPoint.toEntity(),
    purchase = purchase.toEntity(),
    createdAt = createdAt
)

fun UsedPointEntity.toModel() = UsedPoint(
    id = id,
    amount = amount,
    totalPoint = totalPoint.toModel(),
    purchase = purchase.toModel(),
    createdAt = createdAt
)