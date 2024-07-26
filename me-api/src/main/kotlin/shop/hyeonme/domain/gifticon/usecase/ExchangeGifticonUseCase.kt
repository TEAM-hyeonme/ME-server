package shop.hyeonme.domain.gifticon.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.coupon.model.Coupon
import shop.hyeonme.domain.coupon.service.CouponService
import shop.hyeonme.domain.gifticon.service.GifticonService
import shop.hyeonme.domain.inventory.service.InventoryService
import shop.hyeonme.domain.inventory.mapper.exception.NotEnoughInventoryException
import shop.hyeonme.domain.point.model.UsedPoint
import shop.hyeonme.domain.point.service.PointService
import shop.hyeonme.domain.user.service.UserService
import java.time.LocalDateTime
import java.util.*

@UseCase
class ExchangeGifticonUseCase(
    private val gifticonService: GifticonService,
    private val inventoryService: InventoryService,
    private val pointService: PointService,
    private val userService: UserService,
    private val couponService: CouponService
) {
    fun execute(id: UUID) {
        val inventory = inventoryService.findInventory(id)

        val gifticon = gifticonService.findGifticonById(id)
        val userId = userService.findCurrentUserId()
        val point = pointService.countPoint(userId)

        if (gifticon.point > point)
            throw NotEnoughInventoryException("보유한 포인트가 부족합니다. info : [ point = $point, price = ${gifticon.point} ]")

        val coupon = Coupon(
            userId = userId,
            inventory = inventory,
            createdAt = LocalDateTime.now()
        ).run(couponService::saveCoupon)

        val usedPoint = UsedPoint(
            userId = userId,
            amount = gifticon.point,
            coupon = coupon
        ).run(pointService::usePoint)
    }
}