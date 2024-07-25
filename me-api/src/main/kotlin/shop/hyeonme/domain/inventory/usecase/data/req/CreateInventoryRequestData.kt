package shop.hyeonme.domain.inventory.usecase.data.req

import java.time.LocalDateTime

data class CreateInventoryRequestData(
    val expiredAt: LocalDateTime,
    val barcodeUrl: String
)
