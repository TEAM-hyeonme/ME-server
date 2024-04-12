package shop.hyeonme.me.thirdparty.apple.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "apple")
data class AppleProperties(
    val teamId: String,
    val loginKey: String,
    val clientId: String,
    val redirectUrl: String,
    val keyPath: String
)
