package shop.hyeonme.domain.point.exception.error

enum class PointError(
    val status: Int,
) {
    NOT_ENOUGH_POINT(409),
}