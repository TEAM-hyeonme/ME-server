package shop.hyeonme.domain.coupon.mapper

import shop.hyeonme.domain.coupon.presentation.web.res.QueryCouponDetailsWebResponse
import shop.hyeonme.domain.coupon.presentation.web.res.QueryCouponWebResponse
import shop.hyeonme.domain.coupon.presentation.web.res.QueryCouponsWebResponse
import shop.hyeonme.domain.coupon.usecase.data.res.QueryCouponDetailsResponseData
import shop.hyeonme.domain.coupon.usecase.data.res.QueryCouponResponseData
import shop.hyeonme.domain.coupon.usecase.data.res.QueryCouponsResponseData

fun QueryCouponsResponseData.toResponse() = QueryCouponsWebResponse(
    coupons = coupons.map { it.toResponse() }
)

fun QueryCouponResponseData.toResponse() = QueryCouponWebResponse(
    id = id,
    profileUrl = profileUrl,
    brand = brand,
    name = name,
    createdAt = createdAt,
    expiredAt = expiredAt
)

fun QueryCouponDetailsResponseData.toResponse() = QueryCouponDetailsWebResponse(
    barcodeUrl = barcodeUrl
)