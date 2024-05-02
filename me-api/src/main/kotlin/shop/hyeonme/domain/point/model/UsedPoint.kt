package shop.hyeonme.domain.point.model

import shop.hyeonme.domain.purchase.model.Purchase
import java.time.LocalDateTime

data class UsedPoint(
    val id: Long = 0L,
    val amount: Int,
    val totalPoint: TotalPoint,
    val purchase: Purchase,
    val createdAt: LocalDateTime
)