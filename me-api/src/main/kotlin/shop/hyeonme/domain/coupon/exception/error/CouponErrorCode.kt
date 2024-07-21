package shop.hyeonme.domain.coupon.exception.error

import shop.hyeonme.common.exception.ErrorStatus

enum class CouponErrorCode(
    val status: Int
) {
    COUPON_NOT_FOUND(ErrorStatus.NOT_FOUND)
}