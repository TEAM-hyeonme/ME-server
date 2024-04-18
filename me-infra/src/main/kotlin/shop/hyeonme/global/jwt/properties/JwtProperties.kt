package shop.hyeonme.global.jwt.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties (
    val secretKey: String,
    val accessExp: Int,
    val refreshExp: Int
) {
    companion object {
        const val ACCESS = "access"
        const val REFRESH = "refresh"
        const val ROLE = "ROLE"
        const val PREFIX = "Bearer "
        const val HEADER = "Authorization"
    }
}