package shop.hyeonme.domain.coupon.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseUUIDEntity
import shop.hyeonme.domain.inventory.entity.InventoryEntity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "coupon")
class CouponEntity(
    @get:JvmName("getIdentifier")
    override var id: UUID,

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", columnDefinition = "BINARY(16)", nullable = false)
    val inventory: InventoryEntity,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    val createdAt: LocalDateTime
) : BaseUUIDEntity(id)