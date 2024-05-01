package shop.hyeonme.domain.point.entity

import shop.hyeonme.common.base.BaseLongEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "point")
class PointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "user_id", nullable = false)
    val userId: UUID
) : BaseLongEntity(id)