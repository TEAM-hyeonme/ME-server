package shop.hyeonme.domain.gifticon.spi

import shop.hyeonme.domain.gifticon.model.Gifticon

interface CommandGifticonPort {
    fun saveGifticon(gifticon: Gifticon): Gifticon
}