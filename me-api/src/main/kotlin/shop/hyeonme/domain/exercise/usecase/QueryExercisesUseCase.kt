package shop.hyeonme.domain.exercise.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.exercise.service.ExerciseService
import shop.hyeonme.domain.exercise.usecase.data.res.QueryExerciseResponseData
import shop.hyeonme.domain.exercise.usecase.data.res.QueryExercisesResponseData
import shop.hyeonme.domain.point.service.PointService
import shop.hyeonme.domain.user.service.UserService

@ReadOnlyUseCase
class QueryExercisesUseCase(
    private val exerciseService: ExerciseService,
    private val userService: UserService,
    private val pointService: PointService
) {
    fun execute(): QueryExercisesResponseData {
        val userId = userService.findCurrentUserId()
        val point = pointService.countSavedPointByCurrentDate(userId)

        val exercises = exerciseService.findExercisesByCurrentDate(userId)
            .map {
                QueryExerciseResponseData(
                    exerciseType = it.type,
                    calorie = it.calorie
                )
            }.sortedByDescending { it.calorie }

        return QueryExercisesResponseData(
            point = point,
            exercises = exercises
        )
    }
}