package shop.hyeonme.domain.auth.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.auth.service.AuthService
import shop.hyeonme.domain.auth.spi.JwtPort
import shop.hyeonme.domain.auth.usecase.data.res.TokenResponseData
import shop.hyeonme.domain.user.service.UserService

@UseCase
class ReIssueTokenUseCase(
    private val authService: AuthService,
    private val userService: UserService,
    private val jwtPort: JwtPort
) {
    fun execute(request: String): TokenResponseData {
        val refreshToken = authService.queryRefreshToken(request)
        val user = userService.findById(refreshToken.userId)

        authService.deleteRefreshToken(refreshToken)

        return jwtPort.receiveToken(user.id, user.role)
    }
}