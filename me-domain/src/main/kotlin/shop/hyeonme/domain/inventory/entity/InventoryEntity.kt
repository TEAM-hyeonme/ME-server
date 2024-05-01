package shop.hyeonme.domain.inventory.entity

import shop.hyeonme.common.base.BaseUUIDEntity
import shop.hyeonme.domain.gifticon.entity.GifticonEntity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "inventory")
class InventoryEntity(
    @get:JvmName("getIdentifier")
    override var id: UUID,

    @Column(columnDefinition = "DATETIME(6)", nullable = false)
    val expiredAt: LocalDateTime,

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    val barcodeUrl: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gifticon_id", columnDefinition = "")
    val gifticon: GifticonEntity
) : BaseUUIDEntity(id)