package shop.hyeonme.domain.gifticon.presentation.web.res

data class QueryGifticonDetailsWebResponse(
    val name: String,
    val brand: String,
    val profileUrl: String,
    val point: Int,
    val inventory: Int,
    val notice: String
)