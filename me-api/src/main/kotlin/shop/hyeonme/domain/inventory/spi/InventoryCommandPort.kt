package shop.hyeonme.domain.inventory.spi

import shop.hyeonme.domain.inventory.model.Inventory

interface InventoryCommandPort {
    fun saveInventories(inventories: List<Inventory>): List<Inventory>
}