package shop.hyeonme.domain.inventory.service

import shop.hyeonme.domain.inventory.model.Inventory
import java.util.UUID

interface InventoryQueryService {
    fun countInventory(gifticonId: UUID): Int
    fun findInventory(gifticonId: UUID): Inventory
}