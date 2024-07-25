package shop.hyeonme.domain.inventory.mapper

import shop.hyeonme.domain.gifticon.mapper.toEntity
import shop.hyeonme.domain.gifticon.mapper.toModel
import shop.hyeonme.domain.inventory.entity.InventoryEntity
import shop.hyeonme.domain.inventory.model.Inventory

fun Inventory.toEntity() = InventoryEntity(
    id = id,
    createdAt = createdAt,
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl,
    gifticon = gifticon.toEntity()
)

fun List<Inventory>.toEntities() = map(Inventory::toEntity)

fun InventoryEntity.toModel() = Inventory(
    id = id,
    createdAt = createdAt,
    expiredAt = expiredAt,
    barcodeUrl = barcodeUrl,
    gifticon = gifticon.toModel()
)

fun Iterable<InventoryEntity>.toModels() = map(InventoryEntity::toModel)

fun List<InventoryEntity>.toModels() = map(InventoryEntity::toModel)