package shop.hyeonme.domain.point

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import shop.hyeonme.domain.exercise.entity.QExerciseEntity.exerciseEntity
import shop.hyeonme.domain.point.entity.QSavedPointEntity.savedPointEntity
import shop.hyeonme.domain.point.mapper.toEntity
import shop.hyeonme.domain.point.mapper.toModel
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.repository.SavedPointRepository
import shop.hyeonme.domain.point.repository.UsedPointRepository
import shop.hyeonme.domain.point.spi.PointPort
import java.time.LocalDate
import java.util.*

@Component
class PointPersistenceAdapter(
    private val queryFactory: JPAQueryFactory,
    private val savedPointRepository: SavedPointRepository,
    private val usedPointRepository: UsedPointRepository
) : PointPort {
    override fun savePoint(savedPoint: SavedPoint): SavedPoint =
        savedPointRepository.save(savedPoint.toEntity()).toModel()

    override fun findSavedPointByDate(userId: UUID, date: LocalDate): SavedPoint? =
        savedPointRepository.findByUserIdAndCreatedAt(userId, date)?.toModel()

    override fun countSavedPointByDate(userId: UUID, date: LocalDate): Int =
        queryFactory
            .select(
                savedPointEntity.amount
            )
            .from(savedPointEntity)
            .where(
                exerciseEntity.userId.eq(userId),
                exerciseEntity.createdAt.eq(date)
            )
            .fetchOne() ?: 0

}