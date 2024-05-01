package shop.hyeonme.domain.inventory.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.inventory.entity.InventoryEntity
import java.util.UUID

interface InventoryRepository : CrudRepository<InventoryEntity, UUID>