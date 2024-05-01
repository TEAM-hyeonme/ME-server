package shop.hyeonme.domain.gifticon.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.gifticon.entity.GifticonEntity
import java.util.UUID

interface GifticonRepository : CrudRepository<GifticonEntity, UUID>