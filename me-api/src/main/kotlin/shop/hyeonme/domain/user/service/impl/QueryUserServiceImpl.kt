package shop.hyeonme.domain.user.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.user.exception.UserNotFoundException
import shop.hyeonme.domain.user.model.User
import shop.hyeonme.domain.user.service.QueryUserService
import shop.hyeonme.domain.user.spi.UserPort
import java.util.*

@QueryService
class QueryUserServiceImpl(
    private val userPort: UserPort
) : QueryUserService {
    override fun existByEmail(email: String): Boolean =
        userPort.existByEmail(email)

    override fun findByEmail(email: String): User? =
        userPort.findByEmail(email)

    override fun findById(id: UUID): User =
        userPort.findById(id) ?: throw UserNotFoundException("유저를 찾을 수 없습니다. info : [ userId = $id ]")
}