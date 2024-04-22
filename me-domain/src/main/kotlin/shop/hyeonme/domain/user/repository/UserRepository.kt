package shop.hyeonme.domain.user.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.user.entity.UserEntity
import java.util.UUID

interface UserRepository : CrudRepository<UserEntity, UUID> {
    fun findByEmail(email: String): UserEntity?
    fun existsByEmail(email: String): Boolean
}