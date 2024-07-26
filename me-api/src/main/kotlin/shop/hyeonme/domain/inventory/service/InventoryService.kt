package shop.hyeonme.domain.inventory.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class InventoryService(
    inventoryCommandService: InventoryCommandService,
    inventoryQueryService: InventoryQueryService
) : InventoryCommandService by inventoryCommandService,
    InventoryQueryService by inventoryQueryService