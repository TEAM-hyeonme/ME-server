package shop.hyeonme.domain.exercise.spi

import shop.hyeonme.domain.exercise.model.Exercise
import java.time.LocalDate
import java.util.*

interface QueryExercisePort {
    fun findTopExercisesByDate(userId: UUID, date: LocalDate): List<Exercise>
    fun findExercisesByCurrentDate(userId: UUID, date: LocalDate): List<Exercise>
}