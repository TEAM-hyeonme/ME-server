package shop.hyeonme.domain.user.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.user.model.User
import shop.hyeonme.domain.user.service.CommandUserService
import shop.hyeonme.domain.user.spi.UserPort

@CommandService
class CommandUserServiceImpl(
    private val userPort: UserPort
) : CommandUserService {
    override fun saveUser(user: User): User =
        userPort.saveUser(user)
}