package shop.hyeonme.global.error

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.validation.BindingResult
import org.springframework.web.servlet.NoHandlerFoundException
import shop.hyeonme.common.exception.MeException

data class ErrorResponse(
    val message: String,
    val status: Int
) {
    companion object {
        fun of(e: MeException) =
            ErrorResponse(
                message = e.message,
                status = e.status
            )

        fun of(e: BindingResult): ValidationErrorResponse {
            val fieldErrorMap = e.fieldErrors.associateBy({ it.field }, { it.defaultMessage })

            return ValidationErrorResponse(
                fieldErrorMap,
                GlobalErrorCode.BAD_REQUEST.status
            )
        }

        fun of(e: DataIntegrityViolationException) = DataErrorResponse(
            message = e.message.toString(),
            status = GlobalErrorCode.BAD_REQUEST.status
        )

        fun of(e: NoHandlerFoundException) = NoHandlerErrorResponse(
            message = e.message.toString(),
            status = GlobalErrorCode.BAD_REQUEST.status
        )
    }
}

data class ValidationErrorResponse(
    val fieldError: Map<String, String?>,
    val status: Int
)

data class DataErrorResponse(
    val message: String,
    val status: Int
)

data class NoHandlerErrorResponse(
    val message: String,
    val status: Int
)