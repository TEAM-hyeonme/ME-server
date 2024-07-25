package shop.hyeonme.domain.inventory

import org.springframework.stereotype.Component
import shop.hyeonme.domain.inventory.mapper.toEntities
import shop.hyeonme.domain.inventory.mapper.toModels
import shop.hyeonme.domain.inventory.model.Inventory
import shop.hyeonme.domain.inventory.repository.InventoryRepository
import shop.hyeonme.domain.inventory.spi.InventoryPort

@Component
class InventoryPersistenceAdapter(
    private val inventoryRepository: InventoryRepository
) : InventoryPort {
    override fun saveInventories(inventories: List<Inventory>): List<Inventory> =
        inventoryRepository.saveAll(inventories.toEntities()).toModels()
}