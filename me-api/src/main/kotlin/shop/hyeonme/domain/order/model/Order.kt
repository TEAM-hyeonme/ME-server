package shop.hyeonme.domain.order.model

import shop.hyeonme.domain.coupon.model.Coupon
import java.util.UUID

data class Order(
    val id: Long = 0L,
    val userId: UUID,
    val coupon: Coupon
)