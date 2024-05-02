package shop.hyeonme.domain.gifticon.entity

import shop.hyeonme.common.base.BaseUUIDEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "gifticon")
class GifticonEntity(
    @get:JvmName("getIdentifier")
    override var id: UUID,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    val name: String,

    @Column(columnDefinition = "MEDIUMINT UNSIGNED", nullable = false)
    val point: Int,

    @Column(columnDefinition = "TEXT", nullable = false)
    val notice: String,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    val brand: String,

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    val profileUrl: String
) : BaseUUIDEntity(id)