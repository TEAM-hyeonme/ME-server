package shop.hyeonme.domain.exercise.presentation.web.res

import shop.hyeonme.domain.exercise.model.enums.ExerciseType
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class QueryExerciseWebResponse(
    @Enumerated(EnumType.STRING)
    val exerciseType: ExerciseType,

    val calorie: Int
)