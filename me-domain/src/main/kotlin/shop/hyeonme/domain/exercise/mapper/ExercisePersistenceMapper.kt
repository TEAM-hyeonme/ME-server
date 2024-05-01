package shop.hyeonme.domain.exercise.mapper

import shop.hyeonme.domain.exercise.entity.ExerciseEntity
import shop.hyeonme.domain.exercise.model.Exercise
import shop.hyeonme.domain.point.mapper.toEntity
import shop.hyeonme.domain.point.mapper.toModel

fun Exercise.toEntity() = ExerciseEntity(
    id = id,
    calorie = calorie,
    type = type,
    userId = userId,
    savedPoint = savedPoint.toEntity(),
    createdAt = createdAt
)

fun ExerciseEntity.toModel() = Exercise(
    id = id,
    calorie = calorie,
    type = type,
    userId = userId,
    savedPoint = savedPoint.toModel(),
    createdAt = createdAt
)