package shop.hyeonme.domain.exercise.usecase.data.req

import shop.hyeonme.domain.exercise.model.enums.ExerciseType

data class UpdateExercisesRequestData(
    val exercises: List<UpdateExerciseRequestData>
) {
    data class UpdateExerciseRequestData(
        val exerciseType: ExerciseType,
        val calorie: Int
    )
}
