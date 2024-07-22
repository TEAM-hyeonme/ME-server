package shop.hyeonme.domain.coupon.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.coupon.service.CouponService
import shop.hyeonme.domain.coupon.usecase.data.res.QueryCouponDetailsResponseData
import shop.hyeonme.domain.user.service.UserService
import java.util.*

@ReadOnlyUseCase
class QueryCouponDetailsUseCase(
    private val couponService: CouponService,
    private val userService: UserService,
) {
    fun execute(id: UUID): QueryCouponDetailsResponseData {
        val userId = userService.findCurrentUserId()
        val barcodeUrl = couponService.findUserCouponDetailsById(id, userId)

        return QueryCouponDetailsResponseData(
            barcodeUrl = barcodeUrl
        )
    }
}