package shop.hyeonme.domain.inventory.mapper.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.domain.inventory.mapper.exception.error.InventoryError

class NotEnoughInventoryException(
    message: String
) : MeException(message, InventoryError.NOT_ENOUGH_INVENTORY.status)