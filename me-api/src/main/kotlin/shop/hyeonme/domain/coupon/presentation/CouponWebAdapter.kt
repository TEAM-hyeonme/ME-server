package shop.hyeonme.domain.coupon.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import shop.hyeonme.common.annotation.WebAdapter
import shop.hyeonme.domain.coupon.mapper.toResponse
import shop.hyeonme.domain.coupon.presentation.web.res.QueryCouponDetailsWebResponse
import shop.hyeonme.domain.coupon.presentation.web.res.QueryCouponsWebResponse
import shop.hyeonme.domain.coupon.usecase.QueryCouponDetailsUseCase
import shop.hyeonme.domain.coupon.usecase.QueryCouponsUseCase
import java.util.UUID

@WebAdapter("/coupon")
class CouponWebAdapter(
    private val queryCouponsUseCase: QueryCouponsUseCase,
    private val queryCouponDetailsUseCase: QueryCouponDetailsUseCase
) {

    @GetMapping
    fun queryCoupons(): ResponseEntity<QueryCouponsWebResponse> =
        queryCouponsUseCase.execute()
            .let { ResponseEntity.ok(it.toResponse()) }

    @GetMapping("/{id}")
    fun queryCouponDetails(@PathVariable id: UUID): ResponseEntity<QueryCouponDetailsWebResponse> =
        queryCouponDetailsUseCase.execute(id)
            .let { ResponseEntity.ok(it.toResponse()) }
}