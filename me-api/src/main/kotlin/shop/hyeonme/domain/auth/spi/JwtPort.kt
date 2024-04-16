package shop.hyeonme.domain.auth.spi

import shop.hyeonme.domain.auth.model.Role
import shop.hyeonme.domain.auth.usecase.data.res.TokenResponseData
import java.util.*

interface JwtPort {
    fun receiveToken(userId: UUID, role: Role): TokenResponseData
}