package shop.hyeonme.domain.coupon.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.coupon.service.CouponService
import shop.hyeonme.domain.coupon.usecase.data.res.QueryCouponResponseData
import shop.hyeonme.domain.coupon.usecase.data.res.QueryCouponsResponseData
import shop.hyeonme.domain.user.service.UserService

@ReadOnlyUseCase
class QueryCouponsUseCase(
    private val couponService: CouponService,
    private val userService: UserService
) {
    fun execute(): QueryCouponsResponseData {
        val userId = userService.findCurrentUserId()
        val coupons = couponService.findUserCoupons(userId)

        return QueryCouponsResponseData(
            coupons = coupons.map { coupon ->
                QueryCouponResponseData(
                    id = coupon.id,
                    profileUrl = coupon.gifticon.profileUrl,
                    brand = coupon.gifticon.brand,
                    name = coupon.gifticon.name,
                    createdAt = coupon.inventory.createdAt,
                    expiredAt = coupon.inventory.expiredAt
                )
            }
        )
    }
}