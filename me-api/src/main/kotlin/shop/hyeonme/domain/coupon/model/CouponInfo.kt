package shop.hyeonme.domain.coupon.model

import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.inventory.model.Inventory
import java.util.*

data class CouponInfo(
    val id: UUID,
    val inventory: Inventory,
    val gifticon: Gifticon
)