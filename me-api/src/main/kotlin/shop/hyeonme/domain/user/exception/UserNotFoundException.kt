package shop.hyeonme.domain.user.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.domain.user.exception.error.UserErrorCode

class UserNotFoundException (
    override val message: String
) : MeException(message, UserErrorCode.USER_NOT_FOUND.status)