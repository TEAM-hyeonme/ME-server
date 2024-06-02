package shop.hyeonme.domain.point.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.purchase.entity.PurchaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "used_point")
class UsedPointEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    val amount: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "total_point_id", columnDefinition = "BIGINT", nullable = false)
    val totalPoint: TotalPointEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id", columnDefinition = "BIGINT", nullable = false)
    val purchase: PurchaseEntity,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    var createdAt: LocalDate = LocalDate.now()

) : BaseLongEntity(id)