package shop.hyeonme.domain.order.mapper

import shop.hyeonme.domain.coupon.mapper.toEntity
import shop.hyeonme.domain.coupon.mapper.toModel
import shop.hyeonme.domain.order.entity.OrderEntity
import shop.hyeonme.domain.order.model.Order
import shop.hyeonme.domain.point.mapper.toEntity
import shop.hyeonme.domain.point.mapper.toModel

fun Order.toEntity() = OrderEntity(
    id = id,
    coupon = coupon.toEntity(),
    usedPoint = usedPoint.toEntity(),
    createdAt = createdAt
)

fun OrderEntity.toModel() = Order(
    id = id,
    coupon = coupon.toModel(),
    usedPoint = usedPoint.toModel(),
    createdAt = createdAt
)
