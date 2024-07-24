package shop.hyeonme.domain.gifticon.usecase.data.res

data class QueryGifticonResponseData(
    val id: String,
    val name: String,
    val brand: String,
    val profileUrl: String,
    val point: Int,
    val inventory: Int
)