package shop.hyeonme.domain.exercise.usecase.data.res

import shop.hyeonme.domain.exercise.model.enums.ExerciseType

data class QueryExercisesResponseData(
    val exerciseType: ExerciseType,
    val calorie: Int
)