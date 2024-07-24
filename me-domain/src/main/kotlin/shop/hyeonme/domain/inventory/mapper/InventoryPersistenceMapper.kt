package shop.hyeonme.domain.inventory.mapper

import shop.hyeonme.domain.gifticon.mapper.toEntity
import shop.hyeonme.domain.gifticon.mapper.toModel
import shop.hyeonme.domain.inventory.entity.InventoryEntity
import shop.hyeonme.domain.inventory.model.Inventory

fun Inventory.toDomain() = InventoryEntity(
    id = id,
    createdAt = createdAt,
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl,
    gifticon = gifticon.toEntity()
)

fun InventoryEntity.toModel() = Inventory(
    id = id,
    createdAt = createdAt,
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl,
    gifticon = gifticon.toModel()
)