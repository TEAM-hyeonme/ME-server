package shop.hyeonme.domain.point.spi

import shop.hyeonme.domain.point.model.SavedPoint
import java.time.LocalDate
import java.util.*

interface QueryPointPort {
    fun findSavedPointByDate(userId: UUID, date: LocalDate): SavedPoint?
}