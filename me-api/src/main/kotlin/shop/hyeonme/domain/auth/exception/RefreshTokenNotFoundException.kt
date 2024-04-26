package shop.hyeonme.domain.auth.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.domain.auth.exception.error.AuthErrorCode

class RefreshTokenNotFoundException(
    message: String
) : MeException(message, AuthErrorCode.REFRESH_TOKEN_NOT_FOUND.status)