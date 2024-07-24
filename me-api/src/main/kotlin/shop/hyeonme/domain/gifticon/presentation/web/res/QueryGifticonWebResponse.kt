package shop.hyeonme.domain.gifticon.presentation.web.res

import java.util.*

data class QueryGifticonWebResponse(
    val id: UUID,
    val name: String,
    val brand: String,
    val profileUrl: String,
    val point: Int,
    val inventory: Int
)