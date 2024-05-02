package shop.hyeonme.domain.exercise.spi

import shop.hyeonme.domain.exercise.model.Exercise
import java.util.*

interface QueryExercisePort {
    fun findUserExercisesByCurrentDate(userId: UUID): List<Exercise>
}