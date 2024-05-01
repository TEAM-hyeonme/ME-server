package shop.hyeonme.domain.point.model

import java.util.*

data class Point(
    val id: Long = 0L,
    val amount: Int,
    val userId: UUID
)