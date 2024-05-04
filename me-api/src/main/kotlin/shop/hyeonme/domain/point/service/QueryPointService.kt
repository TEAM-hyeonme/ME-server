package shop.hyeonme.domain.point.service

import shop.hyeonme.domain.point.model.SavedPoint
import shop.hyeonme.domain.point.model.TotalPoint
import java.time.LocalDate
import java.util.*

interface QueryPointService {
    fun findByUserId(id: UUID): TotalPoint
    fun countByUserId(id: UUID): Int
    fun findAllSavedPoint(localDate: LocalDate, userId: UUID): List<SavedPoint>
}