package shop.hyeonme.me.domain.user.repository

import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>