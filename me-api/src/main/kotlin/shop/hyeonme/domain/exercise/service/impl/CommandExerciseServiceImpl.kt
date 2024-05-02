package shop.hyeonme.domain.exercise.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.exercise.service.CommandExerciseService
import shop.hyeonme.domain.exercise.spi.ExercisePort

@CommandService
class CommandExerciseServiceImpl(
    private val exercisePort: ExercisePort
) : CommandExerciseService {
    override fun saveExercises(exercises: List<Exercise>): List<Exercise> =
        exercisePort.saveExercises(exercises)
}