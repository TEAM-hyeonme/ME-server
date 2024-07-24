package shop.hyeonme.domain.gifticon.exception

import shop.hyeonme.common.exception.MeException
import shop.hyeonme.domain.gifticon.exception.error.GifticonErrorCode

class GifticonNotFoundException(
    message : String
) : MeException(message, GifticonErrorCode.GIFTICON_NOT_FOUND.status)