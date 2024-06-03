package shop.hyeonme.domain.point.model

import shop.hyeonme.domain.purchase.model.Purchase
import java.time.LocalDate
import java.util.*

data class UsedPoint(
    val id: Long = 0L,
    val amount: Int,
    val userId: UUID,
    val purchase: Purchase,
    val createdAt: LocalDate = LocalDate.now()
)