package shop.hyeonme.global.security.principal

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import shop.hyeonme.domain.user.service.UserService
import java.util.*

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val userService: UserService
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val userId = UUID.fromString(username)
        val user = userService.findById(userId)
        return AuthDetails(user)
    }
}