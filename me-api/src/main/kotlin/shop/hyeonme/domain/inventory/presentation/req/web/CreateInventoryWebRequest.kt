package shop.hyeonme.domain.inventory.presentation.req.web

import org.hibernate.validator.constraints.URL
import java.time.LocalDateTime
import javax.validation.constraints.Future
import javax.validation.constraints.NotNull

data class CreateInventoryWebRequest(
    @field:Future
    val expiredAt: LocalDateTime,

    @field:URL
    @field:NotNull
    val barcodeUrl: String
)
