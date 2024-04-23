package shop.hyeonme.global.error.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import shop.hyeonme.common.exception.MeException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.servlet.NoHandlerFoundException
import shop.hyeonme.global.error.DataErrorResponse
import shop.hyeonme.global.error.ErrorResponse
import shop.hyeonme.global.error.NoHandlerErrorResponse
import shop.hyeonme.global.error.ValidationErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MeException::class)
    fun meExceptionHandler(e: MeException): ResponseEntity<ErrorResponse> =
        ResponseEntity(ErrorResponse.of(e), HttpStatus.valueOf(e.status))

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<ValidationErrorResponse> =
        ResponseEntity(ErrorResponse.of(e), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ValidationErrorResponse> =
        ResponseEntity(ErrorResponse.of(e), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(e: DataIntegrityViolationException): ResponseEntity<DataErrorResponse> =
        ResponseEntity(ErrorResponse.of(e), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNoHandlerFoundException(e: NoHandlerFoundException): ResponseEntity<NoHandlerErrorResponse> =
        ResponseEntity(ErrorResponse.of(e), HttpStatus.FORBIDDEN)

}