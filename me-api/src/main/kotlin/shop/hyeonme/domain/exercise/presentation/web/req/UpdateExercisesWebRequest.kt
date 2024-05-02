package shop.hyeonme.domain.exercise.presentation.web.req

import shop.hyeonme.domain.exercise.model.enums.ExerciseType
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateExercisesWebRequest(
    @Valid
    @field:NotEmpty(
        message = "운동 데이터 기록이 없습니다."
    )
    val exercises: List<UpdateExerciseWebRequest>
) {
    data class UpdateExerciseWebRequest(
        @Enumerated(EnumType.STRING)
        @field:NotNull
        val exerciseType: ExerciseType,

        @field:NotNull
        @field:Min(
            value = 0,
            message = "칼로리는 음수가 될 수 없습니다."
        )
        val calorie: Int
    )
}
