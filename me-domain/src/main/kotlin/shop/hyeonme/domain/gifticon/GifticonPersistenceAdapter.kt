package shop.hyeonme.domain.gifticon

import org.springframework.stereotype.Component
import shop.hyeonme.domain.gifticon.mapper.toEntity
import shop.hyeonme.domain.gifticon.mapper.toModel
import shop.hyeonme.domain.gifticon.model.Gifticon
import shop.hyeonme.domain.gifticon.repository.GifticonRepository
import shop.hyeonme.domain.gifticon.spi.GifticonPort

@Component
class GifticonPersistenceAdapter(
    private val gifticonRepository: GifticonRepository,
) : GifticonPort {
    override fun saveGifticon(gifticon: Gifticon): Gifticon =
        gifticonRepository.save(gifticon.toEntity()).toModel()
}