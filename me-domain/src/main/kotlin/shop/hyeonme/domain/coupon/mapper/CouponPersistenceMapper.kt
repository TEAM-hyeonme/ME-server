package shop.hyeonme.domain.coupon.mapper

import shop.hyeonme.domain.coupon.entity.CouponEntity
import shop.hyeonme.domain.coupon.model.Coupon
import shop.hyeonme.domain.inventory.mapper.toDomain
import shop.hyeonme.domain.inventory.mapper.toModel

fun Coupon.toEntity() = CouponEntity(
    id = id,
    userId = userId,
    inventory = inventory.toDomain(),
    createdAt = createdAt
)

fun CouponEntity.toModel() = Coupon(
    id = id,
    userId = userId,
    inventory = inventory.toModel(),
    createdAt = createdAt
)