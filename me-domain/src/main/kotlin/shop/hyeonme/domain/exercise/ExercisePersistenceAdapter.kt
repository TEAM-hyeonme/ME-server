package shop.hyeonme.domain.exercise

import org.springframework.stereotype.Component
import shop.hyeonme.domain.exercise.mapper.toEntities
import shop.hyeonme.domain.exercise.mapper.toModels
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.exercise.repository.ExerciseRepository
import shop.hyeonme.domain.exercise.spi.ExercisePort

@Component
class ExercisePersistenceAdapter(
    private val exerciseRepository: ExerciseRepository
) : ExercisePort {
    override fun saveExercises(exercises: List<Exercise>): List<Exercise> =
        exerciseRepository.saveAll(exercises.toEntities()).toList().toModels()
}