package shop.hyeonme.domain.inventory.service

import shop.hyeonme.domain.inventory.model.Inventory

interface InventoryCommandService {
    fun saveInventories(inventories: List<Inventory>): List<Inventory>
}