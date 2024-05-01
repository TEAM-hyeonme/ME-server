package shop.hyeonme.domain.order.model

import shop.hyeonme.domain.coupon.model.Coupon
import shop.hyeonme.domain.point.model.UsedPoint
import java.time.LocalDateTime

data class Order(
    val id: Long = 0L,
    val coupon: Coupon,
    val usedPoint: UsedPoint,
    val createdAt: LocalDateTime
)