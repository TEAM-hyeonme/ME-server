package shop.hyeonme.domain.point.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.point.entity.SavedPointEntity

interface SavedPointRepository : CrudRepository<SavedPointEntity, Long>