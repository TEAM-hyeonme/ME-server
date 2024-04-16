package shop.hyeonme.me.domain.auth

import org.springframework.stereotype.Component
import shop.hyeonme.me.domain.auth.mapper.toEntity
import shop.hyeonme.me.domain.auth.mapper.toModel
import shop.hyeonme.me.domain.auth.model.RefreshToken
import shop.hyeonme.me.domain.auth.repository.RefreshTokenRepository
import shop.hyeonme.me.domain.auth.spi.RefreshTokenPort

@Component
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository
) : RefreshTokenPort {
    override fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken =
        refreshTokenRepository.save(refreshToken.toEntity()).toModel()
}