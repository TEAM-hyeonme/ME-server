package shop.hyeonme.domain.auth.service

import shop.hyeonme.domain.auth.model.RefreshToken

interface QueryAuthService {
    fun queryAppleSignInUrl(): String
    fun queryRefreshToken(refreshToken: String): RefreshToken
}