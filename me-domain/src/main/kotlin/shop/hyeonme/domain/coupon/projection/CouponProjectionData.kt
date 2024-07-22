package shop.hyeonme.domain.coupon.projection

import com.querydsl.core.annotations.QueryProjection
import shop.hyeonme.domain.gifticon.entity.GifticonEntity
import shop.hyeonme.domain.inventory.entity.InventoryEntity
import java.util.UUID

data class CouponInfoProjectionData @QueryProjection constructor(
    val id: UUID,
    val inventory: InventoryEntity,
    val gifticon: GifticonEntity
)