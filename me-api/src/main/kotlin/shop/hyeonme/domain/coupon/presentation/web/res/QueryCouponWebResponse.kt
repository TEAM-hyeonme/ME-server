package shop.hyeonme.domain.coupon.presentation.web.res

import java.time.LocalDateTime
import java.util.UUID

data class QueryCouponWebResponse(
    val id: UUID,
    val profileUrl: String,
    val brand: String,
    val name: String,
    val createdAt: LocalDateTime,
    val expiredAt: LocalDateTime
)