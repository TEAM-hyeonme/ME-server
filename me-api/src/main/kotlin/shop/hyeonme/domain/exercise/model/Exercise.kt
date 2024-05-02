package shop.hyeonme.domain.exercise.model

import shop.hyeonme.domain.exercise.model.enums.ExerciseType
import shop.hyeonme.domain.point.model.SavedPoint
import java.time.LocalDateTime
import java.util.UUID

data class Exercise(
    val id: Long = 0L,
    val calorie: Int,
    val type: ExerciseType,
    val userId: UUID,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
