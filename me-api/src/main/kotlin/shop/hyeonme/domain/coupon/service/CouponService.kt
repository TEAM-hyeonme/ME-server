package shop.hyeonme.domain.coupon.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class CouponService(
    queryCouponService: QueryCouponService
) : QueryCouponService by queryCouponService