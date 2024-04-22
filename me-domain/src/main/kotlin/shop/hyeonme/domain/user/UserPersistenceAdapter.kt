package shop.hyeonme.domain.user

import org.springframework.stereotype.Component
import shop.hyeonme.domain.user.mapper.toEntity
import shop.hyeonme.domain.user.mapper.toModel
import shop.hyeonme.domain.user.model.User
import shop.hyeonme.domain.user.repository.UserRepository
import shop.hyeonme.domain.user.spi.UserPort

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserPort {
    override fun saveUser(user: User): User =
        userRepository.save(user.toEntity()).toModel()

    override fun existByEmail(email: String): Boolean =
        userRepository.existsByEmail(email)

    override fun findByEmail(email: String): User? =
        userRepository.findByEmail(email)?.toModel()
}