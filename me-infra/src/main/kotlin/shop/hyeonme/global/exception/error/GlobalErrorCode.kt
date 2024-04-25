package shop.hyeonme.global.exception.error

enum class GlobalErrorCode(
    val message: String,
    val status: Int
) {
    INTERNAL_SERVER_ERROR("서버 내부 에러", 500),
    BAD_REQUEST("잘못된 요청입니다.", 400),
    INVALID_ROLE("권한을 증명할 수 없는 사용자입니다.", 401),
    FORBIDDEN("접근할 권한이 없습니다.", 403),
    EXPIRED_TOKEN("토큰이 만료되었습니다.", 401),
    INVALID_TOKEN("유효하지 않은 토큰입니다.", 401)
}