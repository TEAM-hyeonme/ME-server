package shop.hyeonme.domain.coupon.usecase.data.res

import java.time.LocalDateTime
import java.util.*

data class QueryCouponResponseData(
    val id: UUID,
    val profileUrl: String,
    val brand: String,
    val name: String,
    val createdAt: LocalDateTime,
    val expiredAt: LocalDateTime
)