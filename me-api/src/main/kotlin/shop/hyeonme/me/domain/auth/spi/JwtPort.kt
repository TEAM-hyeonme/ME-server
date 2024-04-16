package shop.hyeonme.me.domain.auth.spi

import shop.hyeonme.me.domain.auth.model.Role
import shop.hyeonme.me.domain.auth.usecase.data.res.TokenResponseData
import java.util.*

interface JwtPort {
    fun receiveToken(userId: UUID, role: Role): TokenResponseData
}