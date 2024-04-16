package shop.hyeonme.me.domain.auth.mapper

import shop.hyeonme.me.domain.auth.presentation.web.req.AppleSignInWebRequest
import shop.hyeonme.me.domain.auth.presentation.web.res.TokenWebResponse
import shop.hyeonme.me.domain.auth.presentation.web.res.GetAppleSignInUrlWebResponse
import shop.hyeonme.me.domain.auth.usecase.data.req.AppleSignInRequestData
import shop.hyeonme.me.domain.auth.usecase.data.res.TokenResponseData
import shop.hyeonme.me.domain.auth.usecase.data.res.GetAppleSignInUrlResponseData

fun AppleSignInWebRequest.toRequest() = AppleSignInRequestData(
    id = id,
    user = user
)

fun TokenResponseData.toResponse() = TokenWebResponse(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessExpiredAt = accessExpiredAt,
    refreshExpiredAt = refreshExpiredAt,
    role = role
)

fun GetAppleSignInUrlResponseData.toResponse() = GetAppleSignInUrlWebResponse(
    url = url
)