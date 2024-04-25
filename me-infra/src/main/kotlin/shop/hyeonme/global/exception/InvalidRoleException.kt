package shop.hyeonme.global.exception

import shop.hyeonme.global.exception.error.GlobalErrorCode
import shop.hyeonme.common.exception.MeException

class InvalidRoleException(
    message: String
) : MeException(message, GlobalErrorCode.INVALID_ROLE.status)