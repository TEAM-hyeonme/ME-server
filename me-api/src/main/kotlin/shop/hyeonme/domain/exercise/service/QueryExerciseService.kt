package shop.hyeonme.domain.exercise.service

import shop.hyeonme.domain.exercise.model.Exercise
import java.util.*

interface QueryExerciseService {
    fun findExerciseByCurrentDate(userId: UUID): List<Exercise>
}