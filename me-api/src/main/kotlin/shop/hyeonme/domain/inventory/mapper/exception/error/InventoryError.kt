package shop.hyeonme.domain.inventory.mapper.exception.error

enum class InventoryError(
    val status: Int,
) {
    NOT_ENOUGH_INVENTORY(409),
}