package shop.hyeonme.domain.point.model

import shop.hyeonme.domain.order.model.Order
import java.time.LocalDateTime

data class UsedPoint(
    val id: Long = 0L,
    val amount: Int,
    val point: Point,
    val order: Order,
    val createdAt: LocalDateTime
)