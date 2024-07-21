package shop.hyeonme.domain.coupon.spi

import shop.hyeonme.domain.coupon.model.CouponInfo
import java.util.*

interface QueryCouponPort {
    fun findAllCouponsByUserId(userId: UUID): List<CouponInfo>
    fun findUserCouponBarcodeById(id: UUID, userId: UUID): String?
}