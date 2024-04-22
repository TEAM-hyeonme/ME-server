package shop.hyeonme.domain.user.spi

import shop.hyeonme.domain.user.model.User

interface CommandUserPort {
    fun saveUser(user: User): User
}