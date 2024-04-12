package shop.hyeonme.me.thirdparty.apple

import org.springframework.stereotype.Component
import shop.hyeonme.me.common.spi.ApplePort
import shop.hyeonme.me.thirdparty.apple.properties.AppleProperties

@Component
class AppleAdapter(
    private val appleProperties: AppleProperties
) : ApplePort {

    companion object {
        const val APPLE_AUTH_URL = "https://appleid.apple.com"
    }

    override fun getAppleLoginUrl() =
        "$APPLE_AUTH_URL/auth/authorize?" +
            "client_id=${appleProperties.clientId}" +
            "&redirect_uri=${appleProperties.redirectUrl}" +
            "&response_type=code%20id_token&scope=name%20email&response_mode=form_post";
}