package shop.hyeonme.domain.purchase.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.purchase.entity.PurchaseEntity

interface PurchaseRepository : CrudRepository<PurchaseEntity, Long>