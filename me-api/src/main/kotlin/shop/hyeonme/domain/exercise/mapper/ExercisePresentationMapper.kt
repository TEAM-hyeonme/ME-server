package shop.hyeonme.domain.exercise.mapper

import shop.hyeonme.domain.exercise.presentation.web.req.UpdateExercisesWebRequest
import shop.hyeonme.domain.exercise.presentation.web.req.UpdateExercisesWebRequest.UpdateExerciseWebRequest
import shop.hyeonme.domain.exercise.usecase.data.req.UpdateExercisesRequestData
import shop.hyeonme.domain.exercise.usecase.data.req.UpdateExercisesRequestData.UpdateExerciseRequestData

fun UpdateExercisesWebRequest.toRequest() = UpdateExercisesRequestData(
    exercises = exercises.map { it.toRequest() }
)

fun UpdateExerciseWebRequest.toRequest() = UpdateExerciseRequestData(
    exerciseType = exerciseType,
    calorie = calorie
)