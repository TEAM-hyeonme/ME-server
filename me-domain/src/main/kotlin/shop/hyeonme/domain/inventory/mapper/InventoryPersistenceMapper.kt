package shop.hyeonme.domain.inventory.mapper

import shop.hyeonme.domain.gifticon.mapper.toDomain
import shop.hyeonme.domain.gifticon.mapper.toModel
import shop.hyeonme.domain.inventory.entity.InventoryEntity
import shop.hyeonme.domain.inventory.model.Inventory

fun Inventory.toDomain() = InventoryEntity(
    id = id,
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl,
    gifticon = gifticon.toDomain()
)

fun InventoryEntity.toModel() = Inventory(
    id = id,
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl,
    gifticon = gifticon.toModel()
)