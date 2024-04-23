package shop.hyeonme.global.error.exception

open class MeException (
    override val message: String,
    val status: Int
) : RuntimeException(message)