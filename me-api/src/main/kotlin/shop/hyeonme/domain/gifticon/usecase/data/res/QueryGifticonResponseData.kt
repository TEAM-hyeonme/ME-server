package shop.hyeonme.domain.gifticon.usecase.data.res

import java.util.UUID

data class QueryGifticonResponseData(
    val id: UUID,
    val name: String,
    val brand: String,
    val profileUrl: String,
    val point: Int,
    val inventory: Int
)