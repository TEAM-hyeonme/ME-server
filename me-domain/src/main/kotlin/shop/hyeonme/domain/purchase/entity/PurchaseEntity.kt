package shop.hyeonme.domain.purchase.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.coupon.entity.CouponEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "purchase")
class PurchaseEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", columnDefinition = "BINARY(16)", nullable = false)
    val coupon: CouponEntity,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    var createdAt: LocalDateTime = LocalDateTime.now()
) : BaseLongEntity(id)