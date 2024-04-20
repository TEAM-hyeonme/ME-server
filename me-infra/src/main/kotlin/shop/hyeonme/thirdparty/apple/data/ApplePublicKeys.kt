package shop.hyeonme.thirdparty.apple.data

data class ApplePublicKeys(
    val keys: List<ApplePublicKey>
) {
    fun matchesKey(alg: String, kid: String): ApplePublicKey {
        return keys.find { it.alg == alg && it.kid == kid } ?: throw Exception()
    }
}
