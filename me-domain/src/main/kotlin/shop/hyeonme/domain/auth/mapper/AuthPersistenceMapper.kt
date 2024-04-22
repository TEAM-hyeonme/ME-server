package shop.hyeonme.domain.auth.mapper

import shop.hyeonme.domain.auth.entity.RefreshTokenEntity
import shop.hyeonme.domain.auth.model.RefreshToken

fun RefreshToken.toEntity() = RefreshTokenEntity(
    token = token,
    userId = userId
)

fun RefreshTokenEntity.toModel() = RefreshToken(
    token = token,
    userId = userId
)