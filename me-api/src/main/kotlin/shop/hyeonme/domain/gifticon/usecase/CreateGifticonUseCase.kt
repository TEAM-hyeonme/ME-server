package shop.hyeonme.domain.gifticon.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.gifticon.service.GifticonService
import shop.hyeonme.domain.gifticon.usecase.data.req.CreateGifticonRequestData
import shop.hyeonme.domain.gifticon.usecase.data.res.CreateGifticonResponseData

@UseCase
class CreateGifticonUseCase(
    private val gifticonService: GifticonService
) {
    fun execute(request: CreateGifticonRequestData): CreateGifticonResponseData {
        val gifticon = request.run {
            Gifticon(
                name = name,
                brand = brand,
                profileUrl = profileUrl,
                notice = notice,
                point = point
            )
        }.run(gifticonService::saveGifticon)

        return CreateGifticonResponseData(
            id = gifticon.id
        )
    }
}