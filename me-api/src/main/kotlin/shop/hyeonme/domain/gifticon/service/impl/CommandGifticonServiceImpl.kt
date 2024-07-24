package shop.hyeonme.domain.gifticon.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.gifticon.service.CommandGifticonService
import shop.hyeonme.domain.gifticon.spi.GifticonPort

@QueryService
class CommandGifticonServiceImpl(
    private val gifticonPort: GifticonPort
) : CommandGifticonService {
    override fun saveGifticon(gifticon: Gifticon): Gifticon =
        gifticonPort.saveGifticon(gifticon)
}