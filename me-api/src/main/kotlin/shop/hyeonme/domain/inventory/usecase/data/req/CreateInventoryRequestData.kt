package shop.hyeonme.domain.inventory.usecase.data.req

import java.time.LocalDateTime

data class CreateInventoryRequestData(
    private val expiredAt: LocalDateTime,
    private val barcodeUrl: String
)
