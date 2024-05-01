package shop.hyeonme.domain.inventory.model

import shop.hyeonme.domain.gifticon.model.Gifticon
import java.time.LocalDateTime
import java.util.UUID

data class Inventory(
    val id: UUID = UUID(0,0),
    val expiredAt: LocalDateTime,
    val barcodeUrl: String,
    val gifticon: Gifticon,
    val createdDate: LocalDateTime
)
