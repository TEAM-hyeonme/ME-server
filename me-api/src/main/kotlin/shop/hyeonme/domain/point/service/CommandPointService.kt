package shop.hyeonme.domain.point.service

import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.model.UsedPoint

interface CommandPointService {
    fun savePoint(savedPoint: SavedPoint): SavedPoint
    fun usePoint(usedPoint: UsedPoint): UsedPoint
}