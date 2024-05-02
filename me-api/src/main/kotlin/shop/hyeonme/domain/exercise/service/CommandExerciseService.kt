package shop.hyeonme.domain.exercise.service

import shop.hyeonme.domain.exercise.model.Exercise

interface CommandExerciseService {
    fun saveExercises(exercises: List<Exercise>): List<Exercise>
}