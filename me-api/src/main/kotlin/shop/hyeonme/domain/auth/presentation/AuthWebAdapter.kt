package shop.hyeonme.domain.auth.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import shop.hyeonme.common.annotation.WebAdapter
import shop.hyeonme.domain.auth.mapper.toRequest
import shop.hyeonme.domain.auth.mapper.toResponse
import shop.hyeonme.domain.auth.presentation.web.req.AppleSignInWebRequest
import shop.hyeonme.domain.auth.presentation.web.res.GetAppleSignInUrlWebResponse
import shop.hyeonme.domain.auth.presentation.web.res.TokenWebResponse
import shop.hyeonme.domain.auth.usecase.AppleSignInUseCase
import shop.hyeonme.domain.auth.usecase.GetAppleSignInUrlUseCase
import shop.hyeonme.domain.auth.usecase.LogoutUseCase
import shop.hyeonme.domain.auth.usecase.ReIssueTokenUseCase
import javax.validation.Valid

@WebAdapter("/auth")
class AuthWebAdapter(
    private val getAppleSignInUrlUseCase: GetAppleSignInUrlUseCase,
    private val appleSignInUseCase: AppleSignInUseCase,
    private val reIssueTokenUseCase: ReIssueTokenUseCase,
    private val logoutUseCase: LogoutUseCase
) {
    @GetMapping("/apple")
    fun getAppleSignInUrl(): ResponseEntity<GetAppleSignInUrlWebResponse> =
        getAppleSignInUrlUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }

    @PostMapping("/apple")
    fun appleSignIn(@Valid webRequest: AppleSignInWebRequest): ResponseEntity<TokenWebResponse> =
        appleSignInUseCase.execute(webRequest.toRequest())
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }

    @PatchMapping
    fun reIssueToken(@RequestHeader("Refresh-Token") token: String): ResponseEntity<TokenWebResponse> =
        reIssueTokenUseCase.execute(token)
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }

    @DeleteMapping
    fun logout(@RequestHeader("Refresh-Token") token: String): ResponseEntity<Unit> =
        logoutUseCase.execute(token)
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }

}