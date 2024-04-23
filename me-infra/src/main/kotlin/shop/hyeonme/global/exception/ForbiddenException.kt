package shop.hyeonme.global.exception

import shop.hyeonme.global.error.GlobalErrorCode
import shop.hyeonme.common.exception.MeException

class ForbiddenException(
    message: String
) : MeException(message, GlobalErrorCode.FORBIDDEN.status)