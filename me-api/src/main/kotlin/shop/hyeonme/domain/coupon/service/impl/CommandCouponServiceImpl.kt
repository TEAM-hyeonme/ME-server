package shop.hyeonme.domain.coupon.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.coupon.model.Coupon
import shop.hyeonme.domain.coupon.service.CommandCouponService
import shop.hyeonme.domain.coupon.spi.CouponPort

@CommandService
class CommandCouponServiceImpl(
    private val couponPort: CouponPort
) : CommandCouponService {
    override fun saveCoupon(coupon: Coupon): Coupon =
        couponPort.saveCoupon(coupon)
}