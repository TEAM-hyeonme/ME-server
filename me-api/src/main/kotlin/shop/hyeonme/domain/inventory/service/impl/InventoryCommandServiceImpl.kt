package shop.hyeonme.domain.inventory.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.inventory.model.Inventory
import shop.hyeonme.domain.inventory.service.InventoryCommandService
import shop.hyeonme.domain.inventory.spi.InventoryPort

@CommandService
class InventoryCommandServiceImpl(
    private val inventoryPort: InventoryPort
) : InventoryCommandService {
    override fun saveInventories(inventories: List<Inventory>): List<Inventory> =
        inventoryPort.saveInventories(inventories)
}