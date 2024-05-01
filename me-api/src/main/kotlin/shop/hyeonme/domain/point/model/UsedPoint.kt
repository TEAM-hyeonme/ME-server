package shop.hyeonme.domain.point.model

import java.time.LocalDateTime

data class UsedPoint(
    val id: Long = 0L,
    val amount: Int,
    val point: Point,
    val createdAt: LocalDateTime
)