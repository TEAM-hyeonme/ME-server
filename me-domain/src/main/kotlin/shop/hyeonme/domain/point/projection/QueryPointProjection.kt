package shop.hyeonme.domain.point.projection

import com.querydsl.core.annotations.QueryProjection

data class CountAllPointProjectionData @QueryProjection constructor(
    val savedPoint: Int,
    val usedPoint: Int
)