package shop.hyeonme.domain.exercise.model

import shop.hyeonme.domain.exercise.model.enums.ExerciseType
import shop.hyeonme.domain.user.model.User

data class Exercise(
    val id: Long = 0L,
    val calorie: Int,
    val type: ExerciseType,
    val user: User
)
