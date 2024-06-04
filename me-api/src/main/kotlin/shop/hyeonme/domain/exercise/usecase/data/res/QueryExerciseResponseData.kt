package shop.hyeonme.domain.exercise.usecase.data.res

import shop.hyeonme.domain.exercise.model.enums.ExerciseType

data class QueryExerciseResponseData(
    val exerciseType: ExerciseType,
    val calorie: Int
)