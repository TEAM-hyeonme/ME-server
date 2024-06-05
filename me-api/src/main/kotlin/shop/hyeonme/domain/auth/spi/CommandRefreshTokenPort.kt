package shop.hyeonme.domain.auth.spi

import shop.hyeonme.domain.auth.model.RefreshToken
import java.util.*


interface CommandRefreshTokenPort {
    fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken
    fun deleteRefreshToken(refreshToken: RefreshToken)
    fun deleteRefreshTokenByUserId(userId: UUID)
}