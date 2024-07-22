package shop.hyeonme.domain.coupon

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import shop.hyeonme.domain.coupon.mapper.toModels
import shop.hyeonme.domain.coupon.model.CouponInfo
import shop.hyeonme.domain.coupon.repository.CouponRepository
import shop.hyeonme.domain.coupon.spi.CouponPort
import java.util.*
import shop.hyeonme.domain.coupon.projection.QCouponInfoProjectionData as CouponInfoProjectionData
import shop.hyeonme.domain.gifticon.entity.QGifticonEntity.gifticonEntity as gifticon
import shop.hyeonme.domain.inventory.entity.QInventoryEntity.inventoryEntity as inventory
import shop.hyeonme.domain.coupon.entity.QCouponEntity.couponEntity as coupon

@Component
class CouponPersistenceAdapter(
    private val queryFactory: JPAQueryFactory,
    private val couponRepository: CouponRepository
) : CouponPort {
    override fun findAllCouponsByUserId(userId: UUID): List<CouponInfo> =
        queryFactory.select(
            CouponInfoProjectionData(
                coupon.id,
                inventory,
                gifticon
            )
        ).from(coupon)
            .innerJoin(coupon.inventory, inventory)
            .innerJoin(inventory.gifticon, gifticon)
            .where(
                coupon.userId.eq(userId)
            )
            .orderBy(inventory.expiredAt.desc())
            .fetch()
            .toModels()

    override fun findUserCouponBarcodeById(id: UUID, userId: UUID): String? =
        queryFactory.select(
            inventory.barcodeUrl
        ).from(coupon)
            .innerJoin(coupon.inventory, inventory)
            .where(
                coupon.id.eq(id),
                coupon.userId.eq(userId)
            )
            .fetchFirst()
}