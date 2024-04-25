package shop.hyeonme.common.exception

open class MeException (
    override val message: String,
    val status: Int
) : RuntimeException(message)