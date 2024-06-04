package shop.hyeonme.domain.exercise.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.exercise.service.ExerciseService
import shop.hyeonme.domain.exercise.usecase.data.res.QueryExercisesResponseData
import shop.hyeonme.domain.exercise.usecase.data.res.QueryTopExercisesResponseData
import shop.hyeonme.domain.user.service.UserService

@ReadOnlyUseCase
class QueryTopExercisesUseCase(
    private val exerciseService: ExerciseService,
    private val userService: UserService
) {
    fun execute(): QueryTopExercisesResponseData {
        val userId = userService.findCurrentUserId()
        val exercises = exerciseService.findTopExercisesByCurrentDate(userId)
            .map {
                QueryExercisesResponseData(
                    exerciseType = it.type,
                    calorie = it.calorie
                )
            }

        return QueryTopExercisesResponseData(
            exercises = exercises
        )
    }
}