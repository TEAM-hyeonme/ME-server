package shop.hyeonme.domain.gifticon.usecase.data.req

data class CreateGifticonRequestData(
    val name: String,
    val brand: String,
    val profileUrl: String,
    val notice: String,
    val point: Int
)
