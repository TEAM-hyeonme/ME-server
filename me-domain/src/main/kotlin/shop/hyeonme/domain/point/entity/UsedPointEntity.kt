package shop.hyeonme.domain.point.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.purchase.entity.PurchaseEntity
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "used_point")
class UsedPointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    val amount: Int,

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id", columnDefinition = "BIGINT", nullable = false)
    val purchase: PurchaseEntity,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    var createdAt: LocalDate = LocalDate.now()

) : BaseLongEntity(id)