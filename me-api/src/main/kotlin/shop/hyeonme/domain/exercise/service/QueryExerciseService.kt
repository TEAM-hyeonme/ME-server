package shop.hyeonme.domain.exercise.service

import shop.hyeonme.domain.exercise.model.Exercise
import java.util.*

interface QueryExerciseService {
    fun findExercisesByCurrentDate(userId: UUID): List<Exercise>
    fun findTopExercisesByCurrentDate(userId: UUID): List<Exercise>
}