package shop.hyeonme.domain.point.model

import java.time.LocalDate

data class SavedPoint(
    val id: Long = 0L,
    val amount: Int,
    val totalPoint: TotalPoint,
    val createdAt: LocalDate
)