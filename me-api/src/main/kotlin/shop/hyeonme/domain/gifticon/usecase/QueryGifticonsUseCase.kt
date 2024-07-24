package shop.hyeonme.domain.gifticon.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.gifticon.service.GifticonService
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonResponseData
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonsResponseData

@ReadOnlyUseCase
class QueryGifticonsUseCase(
    private val gifticonService: GifticonService
) {
    fun execute(): QueryGifticonsResponseData {
        val gifticons = gifticonService.findGifticons()

        return QueryGifticonsResponseData(
            gifticons = gifticons.map { gifticon ->
                QueryGifticonResponseData(
                    id = gifticon.id,
                    name = gifticon.name,
                    brand = gifticon.brand,
                    profileUrl = gifticon.profileUrl,
                    point = gifticon.point,
                    inventory = gifticon.inventory
                )
            }
        )
    }
}