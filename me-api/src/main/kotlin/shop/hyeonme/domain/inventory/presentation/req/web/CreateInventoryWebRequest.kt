package shop.hyeonme.domain.inventory.presentation.req.web

import org.hibernate.validator.constraints.URL
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.validation.constraints.Future
import javax.validation.constraints.NotNull

data class CreateInventoryWebRequest(
    @field:Future
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    val expiredAt: LocalDateTime,

    @field:URL
    @field:NotNull
    val barcodeUrl: String
)
