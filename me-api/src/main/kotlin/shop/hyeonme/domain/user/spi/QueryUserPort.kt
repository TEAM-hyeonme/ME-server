package shop.hyeonme.domain.user.spi

import shop.hyeonme.domain.user.model.User

interface QueryUserPort {
    fun existByEmail(email: String): Boolean
    fun findByEmail(email: String): User?
}