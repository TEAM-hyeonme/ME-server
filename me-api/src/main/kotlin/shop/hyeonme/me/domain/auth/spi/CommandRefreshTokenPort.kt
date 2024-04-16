package shop.hyeonme.me.domain.auth.spi

import shop.hyeonme.me.domain.auth.model.RefreshToken


interface CommandRefreshTokenPort {
    fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken
}