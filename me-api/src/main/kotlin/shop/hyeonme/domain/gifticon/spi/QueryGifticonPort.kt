package shop.hyeonme.domain.gifticon.spi

import shop.hyeonme.domain.gifticon.model.GifticonInfo
import java.util.*

interface QueryGifticonPort {
    fun findGifticons(): List<GifticonInfo>
    fun findGifticonDetailsById(id: UUID): GifticonInfo?
}