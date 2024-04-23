package shop.hyeonme.domain.user.spi

import shop.hyeonme.domain.user.model.User
import java.util.UUID

interface QueryUserPort {
    fun existByEmail(email: String): Boolean
    fun findByEmail(email: String): User?
    fun findById(id: UUID): User?
}