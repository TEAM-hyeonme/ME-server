package shop.hyeonme.domain.point.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.exercise.entity.ExerciseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "saved_point")
class SavedPointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "UNSIGNED INT", nullable = false)
    val amount: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id", columnDefinition = "BINARY(16)", nullable = false)
    val point: PointEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", columnDefinition = "BIGINT", nullable = false)
    val exercise: ExerciseEntity,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    var createdAt: LocalDateTime = LocalDateTime.now()

) : BaseLongEntity(id)