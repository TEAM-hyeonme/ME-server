package shop.hyeonme.me.domain.auth.mapper

import shop.hyeonme.me.domain.auth.presentation.web.req.AppleSignInWebRequest
import shop.hyeonme.me.domain.auth.presentation.web.res.AppleSignInWebResponse
import shop.hyeonme.me.domain.auth.usecase.data.req.AppleSignInRequestData
import shop.hyeonme.me.domain.auth.usecase.data.res.AppleSignInResponseData

fun AppleSignInWebRequest.toRequest() = AppleSignInRequestData(
    id = id,
    user = user
)

fun AppleSignInResponseData.toResponse() = AppleSignInWebResponse(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessExpiredAt = accessExpiredAt,
    refreshExpiredAt = refreshExpiredAt,
    role = role
)