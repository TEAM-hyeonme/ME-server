package shop.hyeonme.domain.exercise.spi

import shop.hyeonme.domain.exercise.model.Exercise

interface CommandExercisePort {
    fun saveExercises(exercises: List<Exercise>): List<Exercise>
}