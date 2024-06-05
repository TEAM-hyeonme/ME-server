package shop.hyeonme.domain.point

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import shop.hyeonme.domain.point.entity.QSavedPointEntity.savedPointEntity
import shop.hyeonme.domain.point.entity.QUsedPointEntity.usedPointEntity
import shop.hyeonme.domain.point.mapper.toEntity
import shop.hyeonme.domain.point.mapper.toModel
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.projection.QCountAllPointProjectionData
import shop.hyeonme.domain.point.repository.SavedPointRepository
import shop.hyeonme.domain.point.spi.PointPort
import java.time.LocalDate
import java.util.*

@Component
class PointPersistenceAdapter(
    private val queryFactory: JPAQueryFactory,
    private val savedPointRepository: SavedPointRepository
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
                savedPointEntity.userId.eq(userId),
                savedPointEntity.createdAt.eq(date)
            )
            .fetchOne() ?: 0

    override fun countPoint(userId: UUID): Int =
        queryFactory
            .select(
                QCountAllPointProjectionData(
                    savedPointEntity.amount.sum(),
                    usedPointEntity.amount.sum()
                )
            )
            .from(savedPointEntity, usedPointEntity)
            .where(
                savedPointEntity.userId.eq(userId),
                usedPointEntity.userId.eq(userId)
            )
            .fetchOne()
            ?.run { savedPoint - usedPoint } ?: 0

}