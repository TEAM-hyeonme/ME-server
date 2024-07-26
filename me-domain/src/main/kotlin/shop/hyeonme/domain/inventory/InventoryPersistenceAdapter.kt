package shop.hyeonme.domain.inventory

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import shop.hyeonme.domain.inventory.mapper.toEntities
import shop.hyeonme.domain.inventory.mapper.toModel
import shop.hyeonme.domain.inventory.mapper.toModels
import shop.hyeonme.domain.inventory.model.Inventory
import shop.hyeonme.domain.inventory.repository.InventoryRepository
import shop.hyeonme.domain.inventory.spi.InventoryPort
import java.util.*
import shop.hyeonme.domain.coupon.entity.QCouponEntity.couponEntity as coupon
import shop.hyeonme.domain.inventory.entity.QInventoryEntity.inventoryEntity as inventory

@Component
class InventoryPersistenceAdapter(
    private val queryFactory: JPAQueryFactory,
    private val inventoryRepository: InventoryRepository
) : InventoryPort {
    override fun saveInventories(inventories: List<Inventory>): List<Inventory> =
        inventoryRepository.saveAll(inventories.toEntities()).toModels()

    override fun countInventory(gifticonId: UUID): Int =
        queryFactory.select(
            inventory.count().intValue()
        ).from(inventory)
            .leftJoin(coupon).on(inventory.eq(coupon.inventory))
            .where(
                coupon.isNull,
                inventory.gifticon.id.eq(gifticonId)
            )
            .fetchFirst()


    override fun findInventory(gifticonId: UUID): Inventory? =
        queryFactory.selectFrom(inventory)
            .leftJoin(coupon).on(inventory.eq(coupon.inventory))
            .where(
                coupon.isNull,
                inventory.gifticon.id.eq(gifticonId)
            )
            .fetchOne()
            ?.toModel()

}