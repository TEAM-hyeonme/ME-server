package shop.hyeonme.domain.point.service.impl

import shop.hyeonme.common.annotation.CommandService
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.service.CommandPointService
import shop.hyeonme.domain.point.spi.PointPort

@CommandService
class CommandPointServiceImpl(
    private val pointPort: PointPort
) : CommandPointService {
    override fun savePoint(savedPoint: SavedPoint): SavedPoint =
        pointPort.savePoint(savedPoint)
}