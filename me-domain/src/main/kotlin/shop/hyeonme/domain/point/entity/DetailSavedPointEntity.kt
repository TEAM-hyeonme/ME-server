package shop.hyeonme.domain.point.entity

import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.exercise.entity.ExerciseEntity
import javax.persistence.*

@Entity
@Table(name = "saved_point")
class DetailSavedPointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    val amount: Int,

    @JoinColumn(name = "saved_point_id", columnDefinition = "BIGINT", nullable = false)
    val detailSavedPointId: Long,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", columnDefinition = "BIGINT", nullable = false)
    val exercise: ExerciseEntity
) : BaseLongEntity(id)