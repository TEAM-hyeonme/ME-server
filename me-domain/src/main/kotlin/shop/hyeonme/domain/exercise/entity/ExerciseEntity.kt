package shop.hyeonme.domain.exercise.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.exercise.model.enums.ExerciseType
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "exercise")
class ExerciseEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    val calorie: Int,

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: ExerciseType,

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    var createdAt: LocalDateTime = LocalDateTime.now()
) : BaseLongEntity(id)