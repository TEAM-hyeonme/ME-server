package shop.hyeonme.domain.user.mapper

import shop.hyeonme.domain.user.entity.UserEntity
import shop.hyeonme.domain.user.model.User

fun User.toEntity() = UserEntity(
    id = id,
    name = name,
    email = email,
    role = role,
)

fun UserEntity.toModel() = User(
    id = id,
    name = name,
    email = email,
    role = role,
)