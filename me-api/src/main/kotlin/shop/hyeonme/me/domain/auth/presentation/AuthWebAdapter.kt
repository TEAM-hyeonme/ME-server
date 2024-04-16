package shop.hyeonme.me.domain.auth.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import shop.hyeonme.me.common.annotation.WebAdapter
import shop.hyeonme.me.domain.auth.mapper.toRequest
import shop.hyeonme.me.domain.auth.mapper.toResponse
import shop.hyeonme.me.domain.auth.presentation.web.req.AppleSignInWebRequest
import shop.hyeonme.me.domain.auth.presentation.web.res.TokenWebResponse
import shop.hyeonme.me.domain.auth.presentation.web.res.GetAppleSignInUrlWebResponse
import shop.hyeonme.me.domain.auth.usecase.AppleSignInUseCase
import shop.hyeonme.me.domain.auth.usecase.GetAppleSignInUrlUseCase
import javax.validation.Valid

@WebAdapter("/auth")
class AuthWebAdapter(
    private val getAppleSignInUrlUseCase: GetAppleSignInUrlUseCase,
    private val appleSignInUseCase: AppleSignInUseCase
) {
    @GetMapping("/apple")
    fun getAppleSignInUrl(): ResponseEntity<GetAppleSignInUrlWebResponse> =
        getAppleSignInUrlUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }

    @PostMapping("/apple")
    fun appleSignIn(@RequestBody @Valid webRequest: AppleSignInWebRequest): ResponseEntity<TokenWebResponse> =
        appleSignInUseCase.execute(webRequest.toRequest())
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }
}