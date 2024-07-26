package shop.hyeonme.domain.coupon.spi

import shop.hyeonme.domain.coupon.model.Coupon


interface CommandCouponPort {
    fun saveCoupon(coupon: Coupon): Coupon
}