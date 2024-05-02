package shop.hyeonme.domain.exercise.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class ExerciseService(
    commandExerciseService: CommandExerciseService
) : CommandExerciseService by commandExerciseService