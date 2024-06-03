package shop.hyeonme.domain.exercise.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.exercise.service.ExerciseService
import shop.hyeonme.domain.exercise.usecase.data.req.UpdateExercisesRequestData
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.service.PointService
import shop.hyeonme.domain.user.service.UserService
import kotlin.math.max
import kotlin.math.min

@UseCase
class UpdateExercisesUseCase(
    private val userService: UserService,
    private val exerciseService: ExerciseService,
    private val pointService: PointService
) {
    fun execute(request: UpdateExercisesRequestData) {
        val userId = userService.findCurrentUserId()

        val currentDateExercises = exerciseService.findExerciseByCurrentDate(userId)

        val exercises = request.exercises.map { exercise ->
            currentDateExercises.find { it.type == exercise.exerciseType }
                ?.run {
                    copy(
                        calorie = max(calorie, exercise.calorie)
                    )
                }
                ?: Exercise(
                    calorie = exercise.calorie,
                    type = exercise.exerciseType,
                    userId = userId,
                )
        }

        exerciseService.saveExercises(exercises)

        val currentDateSavedPoint = pointService.findSavedPointByCurrentDate(userId)
            ?: SavedPoint(
                amount = 0,
                userId = userId,
            )

        val totalCalorie = exercises.sumOf { it.calorie }

        val savedPoint = currentDateSavedPoint.copy(
            amount = min(100, totalCalorie/100)
        )

        pointService.savePoint(savedPoint)
    }
}