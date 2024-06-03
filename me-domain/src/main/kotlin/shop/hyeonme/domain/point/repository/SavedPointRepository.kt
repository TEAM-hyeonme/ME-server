package shop.hyeonme.domain.point.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.point.entity.SavedPointEntity
import java.time.LocalDate
import java.util.*

interface SavedPointRepository : CrudRepository<SavedPointEntity, Long> {
    fun findByUserIdAndCreatedAt(userId: UUID, createdAt: LocalDate): SavedPointEntity?
}