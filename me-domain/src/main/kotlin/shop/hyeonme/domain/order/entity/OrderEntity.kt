package shop.hyeonme.domain.order.entity

import org.springframework.data.annotation.CreatedDate
import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.coupon.entity.CouponEntity
import shop.hyeonme.domain.point.entity.UsedPointEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "order")
class OrderEntity(
    @get:JvmName("getIdentifier")
    override var id: Long,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_point_id", columnDefinition = "BINARY(16)", nullable = false)
    val coupon: CouponEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_point_id", columnDefinition = "INT", nullable = false)
    val usedPoint: UsedPointEntity,

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    val createdAt: LocalDateTime
) : BaseLongEntity(id)