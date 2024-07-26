package shop.hyeonme.domain.coupon.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class CouponService(
    queryCouponService: QueryCouponService,
    commandCouponService: CommandCouponService
) : QueryCouponService by queryCouponService,
    CommandCouponService by commandCouponService