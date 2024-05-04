package shop.hyeonme.domain.point.service

import shop.hyeonme.domain.point.model.TotalPoint

interface CommandPointService {
    fun saveTotalPoint(totalPoint: TotalPoint): TotalPoint
}