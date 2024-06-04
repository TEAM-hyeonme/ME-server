package shop.hyeonme.domain.exercise.mapper

import shop.hyeonme.domain.exercise.presentation.web.req.UpdateExercisesWebRequest
import shop.hyeonme.domain.exercise.presentation.web.req.UpdateExercisesWebRequest.UpdateExerciseWebRequest
import shop.hyeonme.domain.exercise.presentation.web.res.QueryExercisesWebResponse
import shop.hyeonme.domain.exercise.presentation.web.res.QueryTopExercisesWebResponse
import shop.hyeonme.domain.exercise.usecase.data.req.UpdateExercisesRequestData
import shop.hyeonme.domain.exercise.usecase.data.req.UpdateExercisesRequestData.UpdateExerciseRequestData
import shop.hyeonme.domain.exercise.usecase.data.res.QueryExercisesResponseData
import shop.hyeonme.domain.exercise.usecase.data.res.QueryTopExercisesResponseData

fun UpdateExercisesWebRequest.toRequest() = UpdateExercisesRequestData(
    exercises = exercises.map { it.toRequest() }
)

fun UpdateExerciseWebRequest.toRequest() = UpdateExerciseRequestData(
    exerciseType = exerciseType,
    calorie = calorie
)

fun QueryExercisesResponseData.toResponse() = QueryExercisesWebResponse(
    exerciseType = exerciseType,
    calorie = calorie
)

fun QueryTopExercisesResponseData.toResponse() = QueryTopExercisesWebResponse(
    exercises = exercises.map { it.toResponse() }
)