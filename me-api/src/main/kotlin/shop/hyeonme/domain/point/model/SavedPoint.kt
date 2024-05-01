package shop.hyeonme.domain.point.model

import java.time.LocalDateTime

data class SavedPoint(
    val id: Long = 0L,
    val amount: Int,
    val point: Point,
    val createdAt: LocalDateTime
)