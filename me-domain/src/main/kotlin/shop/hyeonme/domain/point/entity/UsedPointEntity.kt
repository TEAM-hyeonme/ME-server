package shop.hyeonme.domain.point.entity

import shop.hyeonme.common.base.BaseLongEntity
import javax.persistence.*

@Entity
@Table(name = "used_point")
class UsedPointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "UNSIGNED INT", nullable = false)
    val amount: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id", columnDefinition = "BINARY(16)", nullable = false)
    val point: PointEntity
) : BaseLongEntity(id)