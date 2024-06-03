package shop.hyeonme.domain.point.model

import java.time.LocalDate
import java.util.*

data class SavedPoint(
    val id: Long = 0L,
    val amount: Int,
    val userId: UUID,
    val createdAt: LocalDate = LocalDate.now()
)