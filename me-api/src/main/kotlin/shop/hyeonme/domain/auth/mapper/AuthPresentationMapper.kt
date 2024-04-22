package shop.hyeonme.domain.auth.mapper

import kotlinx.serialization.json.Json
import shop.hyeonme.domain.auth.presentation.web.req.AppleSignInWebRequest
import shop.hyeonme.domain.auth.presentation.web.res.TokenWebResponse
import shop.hyeonme.domain.auth.presentation.web.res.GetAppleSignInUrlWebResponse
import shop.hyeonme.domain.auth.usecase.data.req.AppleSignInRequestData
import shop.hyeonme.domain.auth.usecase.data.req.User
import shop.hyeonme.domain.auth.usecase.data.res.TokenResponseData
import shop.hyeonme.domain.auth.usecase.data.res.GetAppleSignInUrlResponseData

fun AppleSignInWebRequest.toRequest() = AppleSignInRequestData(
    idToken = id_token,
    user = user?.let { Json.decodeFromString<User>(it) }
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