package shop.hyeonme.domain.inventory.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.inventory.mapper.exception.NotEnoughInventoryException
import shop.hyeonme.domain.inventory.model.Inventory
import shop.hyeonme.domain.inventory.service.InventoryQueryService
import shop.hyeonme.domain.inventory.spi.InventoryPort
import java.util.*

@QueryService
class InventoryQueryServiceImpl(
    private val inventoryPort: InventoryPort
) : InventoryQueryService {
    override fun countInventory(gifticonId: UUID): Int =
        inventoryPort.countInventory(gifticonId)

    override fun findInventory(gifticonId: UUID): Inventory =
        inventoryPort.findInventory(gifticonId)
            ?: throw NotEnoughInventoryException("재고가 없습니다. info : [ gifticon id = $gifticonId ]")
}