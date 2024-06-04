package shop.hyeonme.domain.exercise.presentation.web.res

data class QueryExercisesWebResponse(
    val point: Int,
    val exercises: List<QueryExerciseWebResponse>
)