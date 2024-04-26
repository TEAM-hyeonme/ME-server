package shop.hyeonme.domain.auth.service

import shop.hyeonme.domain.auth.model.RefreshToken

interface CommandAuthService {
    fun deleteRefreshToken(refreshToken: RefreshToken)
}