package shop.hyeonme.domain.gifticon.service

import shop.hyeonme.domain.gifticon.model.Gifticon

interface CommandGifticonService {
    fun saveGifticon(gifticon: Gifticon): Gifticon
}