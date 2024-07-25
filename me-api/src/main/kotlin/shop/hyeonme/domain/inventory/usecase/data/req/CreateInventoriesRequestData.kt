package shop.hyeonme.domain.inventory.usecase.data.req

data class CreateInventoriesRequestData(
    val inventories: List<CreateInventoryRequestData>
)