package shop.hyeonme.domain.gifticon.projection

import com.querydsl.core.annotations.QueryProjection
import java.util.*

data class GifticonInfoProjectionData @QueryProjection constructor(
    val id: UUID,
    val name: String,
    val point: Int,
    val notice: String,
    val brand: String,
    val profileUrl: String,
    val inventory: Int
)