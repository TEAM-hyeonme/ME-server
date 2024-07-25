package shop.hyeonme.domain.inventory.mapper

import shop.hyeonme.domain.inventory.presentation.req.web.CreateInventoriesWebRequest
import shop.hyeonme.domain.inventory.presentation.req.web.CreateInventoryWebRequest
import shop.hyeonme.domain.inventory.usecase.data.req.CreateInventoriesRequestData
import shop.hyeonme.domain.inventory.usecase.data.req.CreateInventoryRequestData

fun CreateInventoryWebRequest.toRequest() = CreateInventoryRequestData(
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl
)

fun CreateInventoriesWebRequest.toRequest() = CreateInventoriesRequestData(
    inventories = inventories.map(CreateInventoryWebRequest::toRequest)
)