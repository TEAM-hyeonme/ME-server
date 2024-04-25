package shop.hyeonme.domain.user.exception.error

import shop.hyeonme.common.exception.ErrorStatus

enum class UserErrorCode(
    val status: Int
) {
    USER_NOT_FOUND(ErrorStatus.NOT_FOUND)
}