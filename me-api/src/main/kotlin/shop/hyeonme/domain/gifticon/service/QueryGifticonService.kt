package shop.hyeonme.domain.gifticon.service

import shop.hyeonme.domain.gifticon.model.GifticonInfo
import java.util.*

interface QueryGifticonService {
    fun findGifticons(): List<GifticonInfo>
    fun findGifticonDetailsById(id: UUID): GifticonInfo
}