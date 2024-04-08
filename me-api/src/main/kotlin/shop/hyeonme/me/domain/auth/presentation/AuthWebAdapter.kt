package shop.hyeonme.me.domain.auth.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import shop.hyeonme.me.common.annotation.WebAdapter
import shop.hyeonme.me.domain.auth.mapper.toRequest
import shop.hyeonme.me.domain.auth.mapper.toResponse
import shop.hyeonme.me.domain.auth.presentation.web.req.AppleSignInWebRequest
import shop.hyeonme.me.domain.auth.presentation.web.res.AppleSignInWebResponse
import shop.hyeonme.me.domain.auth.usecase.AppleSignInUseCase
import javax.validation.Valid

@WebAdapter("/auth")
class AuthWebAdapter(
    private val appleSignInUseCase: AppleSignInUseCase
) {
    @PostMapping("/apple")
    fun appleSignIn(@RequestBody @Valid webRequest: AppleSignInWebRequest): ResponseEntity<AppleSignInWebResponse> =
        appleSignInUseCase.execute(webRequest.toRequest())
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }
}