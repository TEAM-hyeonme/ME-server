package shop.hyeonme.common.spi

interface ApplePort {
    fun getAppleLoginUrl(): String
    fun getEmailByAppleIdToken(idToken: String): String
}