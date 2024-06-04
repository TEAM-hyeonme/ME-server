package shop.hyeonme.domain.exercise.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import shop.hyeonme.common.annotation.WebAdapter
import shop.hyeonme.domain.exercise.mapper.toRequest
import shop.hyeonme.domain.exercise.mapper.toResponse
import shop.hyeonme.domain.exercise.presentation.web.req.UpdateExercisesWebRequest
import shop.hyeonme.domain.exercise.presentation.web.res.QueryTopExercisesWebResponse
import shop.hyeonme.domain.exercise.usecase.QueryTopExercisesUseCase
import shop.hyeonme.domain.exercise.usecase.UpdateExercisesUseCase
import javax.validation.Valid

@WebAdapter("/exercise")
class ExerciseWebAdapter(
    private val updateExercisesUseCase: UpdateExercisesUseCase,
    private val queryTopExercisesUseCase: QueryTopExercisesUseCase
) {
    @PutMapping
    fun updateExercises(@Valid @RequestBody webRequest: UpdateExercisesWebRequest): ResponseEntity<Unit> =
        updateExercisesUseCase.execute(webRequest.toRequest())
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }

    @GetMapping("/top")
    fun queryTopExercises(): ResponseEntity<QueryTopExercisesWebResponse> =
        queryTopExercisesUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }
}