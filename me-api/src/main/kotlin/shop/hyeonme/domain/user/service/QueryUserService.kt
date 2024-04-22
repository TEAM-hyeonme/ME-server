package shop.hyeonme.domain.user.service

import shop.hyeonme.domain.user.model.User

interface QueryUserService {
    fun existByEmail(email: String): Boolean
    fun findByEmail(email: String): User?
}