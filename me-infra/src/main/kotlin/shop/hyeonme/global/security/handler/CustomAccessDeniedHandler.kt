package shop.hyeonme.global.security.handler

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import shop.hyeonme.common.logger.LoggerDelegator
import shop.hyeonme.global.exception.InvalidRoleException

class CustomAccessDeniedHandler : AccessDeniedHandler {

    private val log by LoggerDelegator()

    override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, accessDeniedException: AccessDeniedException?) {
        log.warn("========== Access Denied ==========")
        throw InvalidRoleException("권한을 증명할 수 없는 사용자입니다.")
    }
}