package shop.hyeonme.domain.auth.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.common.spi.ApplePort
import shop.hyeonme.domain.auth.service.QueryAuthService

@QueryService
class QueryAuthServiceImpl(
    private val applePort: ApplePort
) : QueryAuthService {
    override fun queryAppleSignInUrl(): String =
        applePort.getAppleLoginUrl()
}