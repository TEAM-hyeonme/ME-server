package shop.hyeonme.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import shop.hyeonme.common.exception.MeException
import shop.hyeonme.common.logger.LoggerDelegator
import shop.hyeonme.global.error.ErrorResponse
import shop.hyeonme.global.exception.error.GlobalErrorCode
import shop.hyeonme.global.exception.InternalServerException
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter : OncePerRequestFilter() {

    private val log by LoggerDelegator()

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        runCatching {
            filterChain.doFilter(request, response)
        }.onFailure { e ->
            when (e) {
                is MeException -> {
                    log.error("Me Exception Occurred - Message = {}, Status = {}",
                        e.message, e.status)
                    sendError(response, ErrorResponse.of(e))
                }
                else -> {
                    log.error("Internal Exception Occurred - Message = {}, Status = {}",
                        e.message, GlobalErrorCode.INTERNAL_SERVER_ERROR.status)
                    sendError(response, ErrorResponse.of(InternalServerException("Internal Server Error")))
                }
            }
        }
    }

    private fun sendError(response: HttpServletResponse, errorResponse: ErrorResponse) {
        val responseString = ObjectMapper().writeValueAsString(errorResponse)
        response.status = errorResponse.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.writer.write(responseString)
    }

}