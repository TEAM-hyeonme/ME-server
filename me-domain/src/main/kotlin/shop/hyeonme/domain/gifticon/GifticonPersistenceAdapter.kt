package shop.hyeonme.domain.gifticon

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import shop.hyeonme.domain.gifticon.mapper.toEntity
import shop.hyeonme.domain.gifticon.mapper.toModel
import shop.hyeonme.domain.gifticon.mapper.toModels
import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.gifticon.model.GifticonInfo
import shop.hyeonme.domain.gifticon.projection.QGifticonInfoProjectionData as GifticonInfoProjectionData
import shop.hyeonme.domain.gifticon.repository.GifticonRepository
import shop.hyeonme.domain.gifticon.spi.GifticonPort
import java.util.*
import shop.hyeonme.domain.coupon.entity.QCouponEntity.couponEntity as coupon
import shop.hyeonme.domain.gifticon.entity.QGifticonEntity.gifticonEntity as gifticon
import shop.hyeonme.domain.inventory.entity.QInventoryEntity.inventoryEntity as inventory

@Component
class GifticonPersistenceAdapter(
    private val queryFactory: JPAQueryFactory,
    private val gifticonRepository: GifticonRepository,
) : GifticonPort {
    override fun saveGifticon(gifticon: Gifticon): Gifticon =
        gifticonRepository.save(gifticon.toEntity()).toModel()

    override fun findGifticons(): List<GifticonInfo> =
        queryFactory.select(
            GifticonInfoProjectionData(
                gifticon.id,
                gifticon.name,
                gifticon.point,
                gifticon.notice,
                gifticon.brand,
                gifticon.profileUrl,
                inventory.count().intValue()
            )
        ).from(gifticon)
            .leftJoin(inventory).on(gifticon.eq(inventory.gifticon))
            .leftJoin(coupon).on(inventory.eq(coupon.inventory))
            .where(
                coupon.isNull
            )
            .groupBy(
                gifticon.id,
                gifticon.name,
                gifticon.point,
                gifticon.notice,
                gifticon.brand,
                gifticon.profileUrl,
                inventory
            )
            .orderBy(
                gifticon.name.asc()
            )
            .fetch()
            .toModels()

    override fun findGifticonById(id: UUID): Gifticon? =
        gifticonRepository.findByIdOrNull(id)?.toModel()

    override fun findGifticonDetailsById(id: UUID): GifticonInfo? =
        queryFactory.select(
            GifticonInfoProjectionData(
                gifticon.id,
                gifticon.name,
                gifticon.point,
                gifticon.notice,
                gifticon.brand,
                gifticon.profileUrl,
                inventory.count().intValue()
            )
        ).from(gifticon)
            .leftJoin(inventory).on(gifticon.eq(inventory.gifticon))
            .leftJoin(coupon).on(inventory.eq(coupon.inventory))
            .where(
                gifticon.id.eq(id),
                coupon.isNull
            )
            .groupBy(
                gifticon.id,
                gifticon.name,
                gifticon.point,
                gifticon.notice,
                gifticon.brand,
                gifticon.profileUrl,
                inventory
            )
            .fetchFirst()
            .toModel()
}