package shop.hyeonme.domain.point.service

import shop.hyeonme.domain.point.model.SavedPoint

interface CommandPointService {
    fun savePoint(savedPoint: SavedPoint): SavedPoint
}