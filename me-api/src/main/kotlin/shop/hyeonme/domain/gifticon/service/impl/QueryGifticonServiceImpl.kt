package shop.hyeonme.domain.gifticon.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.gifticon.exception.GifticonNotFoundException
import shop.hyeonme.domain.gifticon.model.GifticonInfo
import shop.hyeonme.domain.gifticon.service.QueryGifticonService
import shop.hyeonme.domain.gifticon.spi.GifticonPort
import java.util.*

@QueryService
class QueryGifticonServiceImpl(
    private val gifticonPort: GifticonPort
) : QueryGifticonService {
    override fun findGifticons(): List<GifticonInfo> =
        gifticonPort.findGifticons()

    override fun findGifticonDetailsById(id: UUID): GifticonInfo =
        gifticonPort.findGifticonDetailsById(id)
            ?: throw GifticonNotFoundException("기프티콘을 찾을 수 없습니다. info : [ gifticon id = $id ]")
}