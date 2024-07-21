package shop.hyeonme.domain.coupon.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.domain.coupon.exception.error.CouponErrorCode

class CouponNotFoundException(
    message : String
) : MeException(message, CouponErrorCode.COUPON_NOT_FOUND.status)