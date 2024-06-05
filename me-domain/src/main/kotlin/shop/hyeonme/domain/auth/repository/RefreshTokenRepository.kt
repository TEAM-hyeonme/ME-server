package shop.hyeonme.domain.auth.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.auth.entity.RefreshTokenEntity
import java.util.*

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, Long> {
    fun findByToken(token: String): RefreshTokenEntity?
    fun deleteByUserId(userId: UUID)
}