package shop.hyeonme.domain.auth.exception.error

import shop.hyeonme.common.exception.ErrorStatus

enum class AuthErrorCode(
    val status: Int
) {
    REFRESH_TOKEN_NOT_FOUND(ErrorStatus.NOT_FOUND)
}