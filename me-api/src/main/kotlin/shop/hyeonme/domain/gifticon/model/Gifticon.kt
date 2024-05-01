package shop.hyeonme.domain.gifticon.model

import java.util.*

data class Gifticon(
    val id: UUID = UUID(0,0),
    val name: String,
    val point: Int,
    val notice: String,
    val brand: String,
    val profileUrl: String
)