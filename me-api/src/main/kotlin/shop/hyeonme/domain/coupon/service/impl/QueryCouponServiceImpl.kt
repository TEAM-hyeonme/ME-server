package shop.hyeonme.domain.coupon.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.coupon.exception.CouponNotFoundException
import shop.hyeonme.domain.coupon.model.CouponInfo
import shop.hyeonme.domain.coupon.service.QueryCouponService
import shop.hyeonme.domain.coupon.spi.CouponPort
import java.util.*

@QueryService
class QueryCouponServiceImpl(
    private val couponPort: CouponPort
) : QueryCouponService  {
    override fun findUserCoupons(userId: UUID): List<CouponInfo> =
        couponPort.findAllCouponsByUserId(userId)

    override fun findUserCouponDetailsById(id: UUID, userId: UUID): String =
        couponPort.findUserCouponBarcodeById(id, userId)
            ?: throw CouponNotFoundException("쿠폰을 찾을 수 없습니다. info : [ coupon id = $id ]")
}