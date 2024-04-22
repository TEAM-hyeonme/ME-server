package shop.hyeonme.domain.user.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.user.model.User
import shop.hyeonme.domain.user.service.QueryUserService
import shop.hyeonme.domain.user.spi.UserPort

@QueryService
class QueryUserServiceImpl(
    private val userPort: UserPort
) : QueryUserService {
    override fun existByEmail(email: String): Boolean =
        userPort.existByEmail(email)

    override fun findByEmail(email: String): User? =
        userPort.findByEmail(email)
}