package shop.hyeonme.domain.auth.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.domain.auth.service.AuthService
import shop.hyeonme.domain.user.service.UserService

@UseCase
class LogoutUseCase(
    private val userService: UserService,
    private val authService: AuthService
) {
    fun execute(token: String) {
        val userId = userService.findCurrentUserId()
        val refreshToken = authService.queryRefreshToken(token)

        authService.deleteRefreshToken(refreshToken)
    }
}