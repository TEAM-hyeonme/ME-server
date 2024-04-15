package shop.hyeonme.me.domain.auth.usecase

import shop.hyeonme.me.common.annotation.ReadOnlyUseCase
import shop.hyeonme.me.domain.auth.service.AuthService
import shop.hyeonme.me.domain.auth.usecase.data.res.GetAppleSignInUrlResponseData

@ReadOnlyUseCase
class GetAppleSignInUrlUseCase(
    private val authService: AuthService
){
    fun execute(): GetAppleSignInUrlResponseData {
        val appleSignInUrl = authService.queryAppleSignInUrl()

        return GetAppleSignInUrlResponseData(
            url = appleSignInUrl
        )
    }
}