package shop.hyeonme.global.security.handler

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import shop.hyeonme.common.logger.LoggerDelegator
import shop.hyeonme.global.exception.ForbiddenException

class CustomAuthenticationEntryPointHandler : AuthenticationEntryPoint {

    private val log by LoggerDelegator()

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        log.warn("========== AuthenticationEntryPoint ==========")
        throw ForbiddenException("접근할 권한이 없습니다.")
    }
}