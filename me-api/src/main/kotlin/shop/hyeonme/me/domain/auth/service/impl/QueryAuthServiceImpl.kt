package shop.hyeonme.me.domain.auth.service.impl

import shop.hyeonme.me.common.annotation.QueryService
import shop.hyeonme.me.common.spi.ApplePort
import shop.hyeonme.me.domain.auth.service.QueryAuthService

@QueryService
class QueryAuthServiceImpl(
    private val applePort: ApplePort
) : QueryAuthService {
    override fun queryAppleSignInUrl(): String =
        applePort.getAppleLoginUrl()
}