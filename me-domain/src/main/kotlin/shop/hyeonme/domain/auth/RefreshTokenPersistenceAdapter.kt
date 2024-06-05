package shop.hyeonme.domain.auth

import org.springframework.stereotype.Component
import shop.hyeonme.domain.auth.mapper.toEntity
import shop.hyeonme.domain.auth.mapper.toModel
import shop.hyeonme.domain.auth.model.RefreshToken
import shop.hyeonme.domain.auth.repository.RefreshTokenRepository
import shop.hyeonme.domain.auth.spi.RefreshTokenPort
import java.util.*

@Component
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository
) : RefreshTokenPort {
    override fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken =
        refreshTokenRepository.save(refreshToken.toEntity()).toModel()

    override fun deleteRefreshToken(refreshToken: RefreshToken) =
        refreshTokenRepository.delete(refreshToken.toEntity())

    override fun deleteRefreshTokenByUserId(userId: UUID) {
        refreshTokenRepository.deleteByUserId(userId)
    }

    override fun findRefreshTokenByToken(token: String) =
        refreshTokenRepository.findByToken(token)?.toModel()
}