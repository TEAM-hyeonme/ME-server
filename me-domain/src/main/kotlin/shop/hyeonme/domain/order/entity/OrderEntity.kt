package shop.hyeonme.domain.order.entity

import shop.hyeonme.common.base.BaseLongEntity
import shop.hyeonme.domain.coupon.entity.CouponEntity
import shop.hyeonme.domain.point.entity.UsedPointEntity
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
    val usedPoint: UsedPointEntity
) : BaseLongEntity(id)