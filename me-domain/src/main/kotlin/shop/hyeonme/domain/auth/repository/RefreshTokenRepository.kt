package shop.hyeonme.domain.auth.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.auth.entity.RefreshTokenEntity

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, Long> {
    fun findByToken(token: String): RefreshTokenEntity?
}