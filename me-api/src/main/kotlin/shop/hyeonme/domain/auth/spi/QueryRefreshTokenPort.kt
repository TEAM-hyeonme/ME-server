package shop.hyeonme.domain.auth.spi

import shop.hyeonme.domain.auth.model.RefreshToken

interface QueryRefreshTokenPort {
    fun findRefreshTokenByToken(token: String): RefreshToken?
}