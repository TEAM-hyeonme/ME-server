package shop.hyeonme.thirdparty.apple.data

import java.util.Base64;
import java.math.BigInteger
import java.security.spec.RSAPublicKeySpec

data class ApplePublicKey(
    val alg: String,
    val e: String,
    val kid: String,
    val kty: String,
    val n: String,
    val use: String
) {
    fun publicKeySpec() = RSAPublicKeySpec(n.toBytes(), e.toBytes())

    private fun String.toBytes() = BigInteger(1, Base64.getUrlDecoder().decode((this)))
}
