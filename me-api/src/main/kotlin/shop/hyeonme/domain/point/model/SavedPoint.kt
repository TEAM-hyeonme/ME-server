package shop.hyeonme.domain.point.model

import shop.hyeonme.domain.exercise.model.Exercise
import java.time.LocalDate

data class SavedPoint(
    val id: Long = 0L,
    val amount: Int,
    val totalPoint: TotalPoint,
    val exercise: Exercise,
    val createdAt: LocalDate
)