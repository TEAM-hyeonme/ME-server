package shop.hyeonme.thirdparty.apple

import org.springframework.stereotype.Component
import shop.hyeonme.common.spi.ApplePort
import shop.hyeonme.domain.auth.spi.JwtPort
import shop.hyeonme.thirdparty.apple.client.AppleClient
import shop.hyeonme.thirdparty.apple.data.ApplePublicKeys
import shop.hyeonme.thirdparty.apple.properties.AppleProperties
import java.security.KeyFactory
import java.security.PublicKey


@Component
class AppleAdapter(
    private val appleProperties: AppleProperties,
    private val appleClient: AppleClient,
    private val jwtPort: JwtPort
) : ApplePort {

    companion object {
        const val APPLE_AUTH_URL = "https://appleid.apple.com/auth/authorize"
    }

    override fun getAppleLoginUrl() =
        "${APPLE_AUTH_URL}?" +
            "client_id=${appleProperties.clientId}" +
            "&redirect_uri=${appleProperties.redirectUrl}" +
            "&response_type=code%20id_token&scope=name%20email&response_mode=form_post"

    override fun getEmailByAppleIdToken(idToken: String): String {
        val tokenHeaders = jwtPort.getParseHeaders(idToken)
        val applePublicKeys = appleClient.applePublicKeys() ?: throw Exception()
        val applePublicKey = getApplePublicKey(tokenHeaders, applePublicKeys)

        val tokenClaims = jwtPort.getClaims(idToken, applePublicKey)

        return tokenClaims["email"] as String
    }

    private fun getApplePublicKey(tokenHeaders: Map<String, String>, applePublicKeys: ApplePublicKeys): PublicKey {
        val applePublicKey = applePublicKeys.matchesKey(
            tokenHeaders["alg"]!!,
            tokenHeaders["kid"]!!
        )

        try {
            return KeyFactory.getInstance(applePublicKey.kty).generatePublic(applePublicKey.publicKeySpec())
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }
}