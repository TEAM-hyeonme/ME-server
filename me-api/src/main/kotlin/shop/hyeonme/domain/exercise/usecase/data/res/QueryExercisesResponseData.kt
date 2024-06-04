package shop.hyeonme.domain.exercise.usecase.data.res

data class QueryExercisesResponseData(
    val point: Int,
    val exercises: List<QueryExerciseResponseData>
)