package shop.hyeonme.domain.exercise.presentation.web.res

import shop.hyeonme.domain.exercise.model.enums.ExerciseType

data class QueryExerciseWebResponse(
    val exerciseType: ExerciseType,

    val calorie: Int
)