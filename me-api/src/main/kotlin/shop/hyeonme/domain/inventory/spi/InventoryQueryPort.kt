package shop.hyeonme.domain.inventory.spi

import shop.hyeonme.domain.inventory.model.Inventory
import java.util.UUID

interface InventoryQueryPort {
    fun countInventory(gifticonId: UUID): Int
    fun findInventory(gifticonId: UUID): Inventory?
}