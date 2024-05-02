package shop.hyeonme.domain.exercise.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.exercise.service.ExerciseService
import shop.hyeonme.domain.exercise.usecase.data.req.UpdateExercisesRequestData
import shop.hyeonme.domain.user.service.UserService

@UseCase
class UpdateExercisesUseCase(
    private val userService: UserService,
    private val exerciseService: ExerciseService
) {
    fun execute(request: UpdateExercisesRequestData) {
        val userId = userService.findCurrentUserId()

        val exercises = request.exercises.map {
            Exercise(
                calorie = it.calorie,
                type = it.exerciseType,
                userId = userId,
            )
        }

        exerciseService.saveExercises(exercises)
    }
}