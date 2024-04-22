package shop.hyeonme.domain.auth.spi

import shop.hyeonme.domain.auth.model.RefreshToken


interface CommandRefreshTokenPort {
    fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken
}