package shop.hyeonme.domain.point.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.domain.point.exception.error.PointError

class NotEnoughPointException(
    message: String
) : MeException(message, PointError.NOT_ENOUGH_POINT.status)