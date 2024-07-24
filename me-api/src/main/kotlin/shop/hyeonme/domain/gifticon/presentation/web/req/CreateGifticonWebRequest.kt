package shop.hyeonme.domain.gifticon.presentation.web.req

import org.hibernate.validator.constraints.URL
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateGifticonWebRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val brand: String,

    @field:URL
    @field:NotBlank
    val profileUrl: String,

    @field:NotBlank
    val notice: String,

    @field:NotNull
    @field:Min(1)
    val point: Int
)
