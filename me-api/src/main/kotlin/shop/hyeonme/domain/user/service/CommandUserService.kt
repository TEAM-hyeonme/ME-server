package shop.hyeonme.domain.user.service

import shop.hyeonme.domain.user.model.User

interface CommandUserService {
    fun saveUser(user: User): User
}