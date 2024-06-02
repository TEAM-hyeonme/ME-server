package shop.hyeonme.domain.point.model

import shop.hyeonme.domain.exercise.model.Exercise

data class DetailSavedPoint(
    val id: Long = 0L,
    val amount: Int,
    val savedPointId: Long,
    val exercise: Exercise,
)