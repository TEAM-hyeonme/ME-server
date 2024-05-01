package shop.hyeonme.domain.coupon.model

import shop.hyeonme.domain.inventory.model.Inventory
import java.time.LocalDateTime
import java.util.UUID

class Coupon(
    val id: UUID = UUID(0,0),
    val userId: UUID,
    val inventory: Inventory,
    val createdAt: LocalDateTime
)