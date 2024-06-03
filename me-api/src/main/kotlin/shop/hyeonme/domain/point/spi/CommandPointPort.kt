package shop.hyeonme.domain.point.spi

import shop.hyeonme.domain.point.model.SavedPoint

interface CommandPointPort {
    fun savePoint(savedPoint: SavedPoint): SavedPoint
}