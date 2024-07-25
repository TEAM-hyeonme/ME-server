package shop.hyeonme.domain.inventory.presentation.req.web

import javax.validation.Valid
import javax.validation.constraints.NotEmpty

data class CreateInventoriesWebRequest(
    @Valid
    @field:NotEmpty
    val inventories: List<CreateInventoryWebRequest>
)
