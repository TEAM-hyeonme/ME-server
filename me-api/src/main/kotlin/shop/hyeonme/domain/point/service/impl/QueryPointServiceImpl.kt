package shop.hyeonme.domain.point.service.impl

import shop.hyeonme.common.annotation.QueryService
import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.service.QueryPointService
import shop.hyeonme.domain.point.spi.PointPort
import java.time.LocalDate
import java.util.*

@QueryService
class QueryPointServiceImpl(
    private val pointPort: PointPort
) : QueryPointService {
    override fun findSavedPointByCurrentDate(userId: UUID): SavedPoint? =
        pointPort.findSavedPointByDate(userId, LocalDate.now())

    override fun countSavedPointByCurrentDate(userId: UUID): Int =
        pointPort.countSavedPointByDate(userId, LocalDate.now())

}