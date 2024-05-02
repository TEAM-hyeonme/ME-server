package shop.hyeonme.domain.purchase.mapper

import shop.hyeonme.domain.coupon.mapper.toEntity
import shop.hyeonme.domain.coupon.mapper.toModel
import shop.hyeonme.domain.purchase.entity.PurchaseEntity
import shop.hyeonme.domain.purchase.model.Purchase

fun Purchase.toEntity() = PurchaseEntity(
    id = id,
    coupon = coupon.toEntity(),
    createdAt = createdAt
)

fun PurchaseEntity.toModel() = Purchase(
    id = id,
    coupon = coupon.toModel(),
    createdAt = createdAt
)
