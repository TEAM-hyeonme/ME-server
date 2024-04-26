package shop.hyeonme.domain.auth.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.auth.model.RefreshToken
import shop.hyeonme.domain.auth.service.CommandAuthService
import shop.hyeonme.domain.auth.spi.RefreshTokenPort

@CommandService
class CommandAuthServiceImpl(
    private val refreshTokenPort: RefreshTokenPort
) : CommandAuthService {
    override fun deleteRefreshToken(refreshToken: RefreshToken) =
        refreshTokenPort.deleteRefreshToken(refreshToken)
}