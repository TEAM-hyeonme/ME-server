package shop.hyeonme.domain.user.service

import shop.hyeonme.domain.user.model.User
import java.util.UUID

interface QueryUserService {
    fun existByEmail(email: String): Boolean
    fun findByEmail(email: String): User?
    fun findById(id: UUID): User
}