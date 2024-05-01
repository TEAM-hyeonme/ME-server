package shop.hyeonme.domain.exercise.entity

import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.exercise.model.enums.ExerciseType
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "user")
class ExerciseEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "SMALLINT", nullable = false)
    val calorie: Int,

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: ExerciseType,

    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    val userId: UUID
) : BaseLongEntity(id)