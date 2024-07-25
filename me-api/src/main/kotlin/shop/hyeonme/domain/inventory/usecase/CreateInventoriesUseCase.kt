package shop.hyeonme.domain.inventory.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.gifticon.service.GifticonService
import shop.hyeonme.domain.inventory.model.Inventory
import shop.hyeonme.domain.inventory.service.InventoryService
import shop.hyeonme.domain.inventory.usecase.data.req.CreateInventoriesRequestData
import java.time.LocalDateTime
import java.util.*

@UseCase
class CreateInventoriesUseCase(
    private val inventoryService: InventoryService,
    private val gifticonService: GifticonService
) {
    fun execute(gifticonId: UUID, request: CreateInventoriesRequestData) {
        val gifticon = gifticonService.findGifticonById(gifticonId)
        val inventories = request.inventories.map { inventory ->
            Inventory(
                createdAt = LocalDateTime.now(),
                expiredAt = inventory.expiredAt,
                barcodeUrl = inventory.barcodeUrl,
                gifticon = gifticon
            )
        }

        inventoryService.saveInventories(inventories)
    }
}