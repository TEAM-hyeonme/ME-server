package shop.hyeonme.domain.coupon.service

import shop.hyeonme.domain.coupon.model.CouponInfo
import java.util.UUID

interface QueryCouponService {
    fun findUserCoupons(userId: UUID): List<CouponInfo>
    fun findUserCouponDetailsById(id: UUID, userId: UUID): String
}