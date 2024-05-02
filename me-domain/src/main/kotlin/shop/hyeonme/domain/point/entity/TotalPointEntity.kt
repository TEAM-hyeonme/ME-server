package shop.hyeonme.domain.point.entity

import shop.hyeonme.common.base.BaseLongEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "total_point")
class TotalPointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID
) : BaseLongEntity(id)