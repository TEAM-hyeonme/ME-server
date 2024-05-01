package shop.hyeonme.domain.coupon.model

import shop.hyeonme.domain.inventory.model.Inventory
import shop.hyeonme.domain.user.model.User
import java.util.UUID

class Coupon(
    val id: UUID = UUID(0,0),
    val user: User,
    val inventory: Inventory
)