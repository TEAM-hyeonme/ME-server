package shop.hyeonme.domain.exercise.mapper

import shop.hyeonme.domain.exercise.entity.ExerciseEntity
import shop.hyeonme.domain.exercise.model.Exercise

fun Exercise.toEntity() = ExerciseEntity(
    id = id,
    calorie = calorie,
    type = type,
    userId = userId,
    createdAt = createdAt
)

fun ExerciseEntity.toModel() = Exercise(
    id = id,
    calorie = calorie,
    type = type,
    userId = userId,
    createdAt = createdAt
)