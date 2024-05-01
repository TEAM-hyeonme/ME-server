package shop.hyeonme.domain.auth.usecase

import shop.hyeonme.common.annotation.UseCase
import shop.hyeonme.common.spi.ApplePort
import shop.hyeonme.domain.auth.model.enums.Role
import shop.hyeonme.domain.auth.spi.JwtPort
import shop.hyeonme.domain.auth.usecase.data.req.AppleSignInRequestData
import shop.hyeonme.domain.auth.usecase.data.res.TokenResponseData
import shop.hyeonme.domain.user.model.User
import shop.hyeonme.domain.user.service.UserService

@UseCase
class AppleSignInUseCase(
    private val applePort: ApplePort,
    private val jwtPort: JwtPort,
    private val userService: UserService
) {
    fun execute(request: AppleSignInRequestData): TokenResponseData {
        val email = applePort.getEmailByAppleIdToken(request.idToken)
        val name = request.user?.let {
            "${it.name.lastName}${it.name.firstName}"
        } ?: "익명"

        val user = userService.findByEmail(email)
            ?: User(
                email = email,
                name = name,
                role = Role.ROLE_USER
            ).let { userService.saveUser(it) }

        return jwtPort.receiveToken(user.id, user.role)
    }
}