package shop.hyeonme.domain.gifticon.presentation.web.res

data class QueryGifticonWebResponse(
    val id: String,
    val name: String,
    val brand: String,
    val profileUrl: String,
    val point: Int,
    val inventory: Int
)