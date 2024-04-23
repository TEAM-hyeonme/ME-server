package shop.hyeonme.global.exception

import shop.hyeonme.global.error.GlobalErrorCode
import shop.hyeonme.global.error.exception.MeException

class InvalidRoleException(
    message: String
) : MeException(message, GlobalErrorCode.INVALID_ROLE.status)