package shop.hyeonme.domain.gifticon.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.gifticon.service.CommandGifticonService
import shop.hyeonme.domain.gifticon.spi.GifticonPort

@CommandService
class CommandGifticonServiceImpl(
    private val gifticonPort: GifticonPort
) : CommandGifticonService {
    override fun saveGifticon(gifticon: Gifticon): Gifticon =
        gifticonPort.saveGifticon(gifticon)
}