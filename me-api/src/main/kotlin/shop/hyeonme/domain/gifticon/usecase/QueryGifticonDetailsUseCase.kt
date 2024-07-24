package shop.hyeonme.domain.gifticon.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.gifticon.service.GifticonService
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonDetailsResponseData
import shop.hyeonme.domain.gifticon.usecase.data.res.QueryGifticonsResponseData
import java.util.UUID

@ReadOnlyUseCase
class QueryGifticonDetailsUseCase(
    private val gifticonService: GifticonService
) {
    fun execute(id: UUID): QueryGifticonDetailsResponseData {
        val gifticonInfo = gifticonService.findGifticonDetailsById(id)

        return gifticonInfo.run {
            QueryGifticonDetailsResponseData(
                name = name,
                brand = brand,
                profileUrl = profileUrl,
                notice = notice,
                point = point,
                inventory = inventory
            )
        }
    }
}