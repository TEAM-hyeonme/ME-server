package shop.hyeonme.domain.exercise.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.exercise.entity.ExerciseEntity

interface ExerciseRepository : CrudRepository<ExerciseEntity, Long>