package shop.hyeonme.domain.point.spi

import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.model.UsedPoint

interface CommandPointPort {
    fun savePoint(savedPoint: SavedPoint): SavedPoint
    fun usePoint(usedPoint: UsedPoint): UsedPoint
}