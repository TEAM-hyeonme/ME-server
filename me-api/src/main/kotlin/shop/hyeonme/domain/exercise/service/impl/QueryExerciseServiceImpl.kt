package shop.hyeonme.domain.exercise.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.exercise.service.QueryExerciseService
import shop.hyeonme.domain.exercise.spi.ExercisePort
import java.util.*

@QueryService
class QueryExerciseServiceImpl(
    private val exercisePort: ExercisePort
) : QueryExerciseService {

    override fun findExerciseByCurrentDate(userId: UUID): List<Exercise> =
        exercisePort.findUserExercisesByCurrentDate(userId)
}