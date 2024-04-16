package shop.hyeonme.domain.auth.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.auth.service.AuthService
import shop.hyeonme.domain.auth.usecase.data.res.GetAppleSignInUrlResponseData

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