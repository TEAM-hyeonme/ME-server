package shop.hyeonme.global.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.global.error.GlobalErrorCode

class ExpiredTokenException(
    message: String
) : MeException(message, GlobalErrorCode.EXPIRED_TOKEN.status)