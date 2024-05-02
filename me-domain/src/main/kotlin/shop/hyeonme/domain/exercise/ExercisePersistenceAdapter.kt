package shop.hyeonme.domain.exercise

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import shop.hyeonme.domain.exercise.entity.QExerciseEntity.exerciseEntity
import shop.hyeonme.domain.exercise.mapper.toEntities
import shop.hyeonme.domain.exercise.mapper.toModels
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.exercise.repository.ExerciseRepository
import shop.hyeonme.domain.exercise.spi.ExercisePort
import java.time.LocalDate
import java.util.UUID

@Component
class ExercisePersistenceAdapter(
    private val queryFactory: JPAQueryFactory,
    private val exerciseRepository: ExerciseRepository
) : ExercisePort {
    override fun saveExercises(exercises: List<Exercise>): List<Exercise> =
        exerciseRepository.saveAll(exercises.toEntities()).toList().toModels()

    override fun findUserExercisesByCurrentDate(userId: UUID): List<Exercise> =
        queryFactory.selectFrom(exerciseEntity)
            .where(
                exerciseEntity.userId.eq(userId),
                exerciseEntity.createdAt.eq(LocalDate.now())
            )
            .fetch()
            .toModels()
}