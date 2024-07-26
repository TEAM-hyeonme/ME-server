package shop.hyeonme.domain.coupon.service

import shop.hyeonme.domain.coupon.model.Coupon

interface CommandCouponService {
    fun saveCoupon(coupon: Coupon): Coupon
}