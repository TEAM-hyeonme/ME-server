package shop.hyeonme.domain.gifticon.exception.error

import shop.hyeonme.common.exception.ErrorStatus

enum class GifticonErrorCode(
    val status: Int
) {
    GIFTICON_NOT_FOUND(ErrorStatus.NOT_FOUND)
}