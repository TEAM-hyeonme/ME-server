package shop.hyeonme.global.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.global.exception.error.GlobalErrorCode

class InvalidTokenException(
    message: String
) : MeException(message, GlobalErrorCode.INVALID_TOKEN.status)