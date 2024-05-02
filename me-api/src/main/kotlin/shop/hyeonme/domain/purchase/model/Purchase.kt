package shop.hyeonme.domain.purchase.model

import shop.hyeonme.domain.coupon.model.Coupon
import java.time.LocalDateTime

data class Purchase(
    val id: Long = 0L,
    val coupon: Coupon,
    val createdAt: LocalDateTime
)