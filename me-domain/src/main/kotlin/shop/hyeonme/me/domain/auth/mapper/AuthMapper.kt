package shop.hyeonme.me.domain.auth.mapper

import shop.hyeonme.me.domain.auth.entity.RefreshTokenEntity
import shop.hyeonme.me.domain.auth.model.RefreshToken
import java.util.*

fun RefreshToken.toEntity() = RefreshTokenEntity(
    token = token,
    userId = userId
)

fun RefreshTokenEntity.toModel() = RefreshToken(
    token = token,
    userId = userId
)