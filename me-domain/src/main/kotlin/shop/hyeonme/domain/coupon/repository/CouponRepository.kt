package shop.hyeonme.domain.coupon.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.coupon.entity.CouponEntity
import java.util.*

interface CouponRepository : CrudRepository<CouponEntity, UUID>