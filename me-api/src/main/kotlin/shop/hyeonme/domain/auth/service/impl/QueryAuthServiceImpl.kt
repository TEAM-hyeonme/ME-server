package shop.hyeonme.domain.auth.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.common.spi.ApplePort
import shop.hyeonme.domain.auth.exception.RefreshTokenNotFoundException
import shop.hyeonme.domain.auth.model.RefreshToken
import shop.hyeonme.domain.auth.service.QueryAuthService
import shop.hyeonme.domain.auth.spi.RefreshTokenPort

@QueryService
class QueryAuthServiceImpl(
    private val applePort: ApplePort,
    private val refreshTokenPort: RefreshTokenPort
) : QueryAuthService {
    override fun queryAppleSignInUrl(): String =
        applePort.getAppleLoginUrl()

    override fun queryRefreshToken(refreshToken: String): RefreshToken =
        refreshTokenPort.findRefreshTokenByToken(refreshToken)
            ?: throw RefreshTokenNotFoundException("존재하지 않거나 만료된 리프레쉬 토큰입니다. info : [ token = $refreshToken ]")
}