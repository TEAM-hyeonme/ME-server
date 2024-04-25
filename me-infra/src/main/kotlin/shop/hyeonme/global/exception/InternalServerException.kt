package shop.hyeonme.global.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.global.exception.error.GlobalErrorCode

class InternalServerException(
    message: String
) : MeException(message, GlobalErrorCode.INTERNAL_SERVER_ERROR.status)