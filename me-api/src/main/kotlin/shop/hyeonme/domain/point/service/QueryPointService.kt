package shop.hyeonme.domain.point.service

import shop.hyeonme.domain.point.model.SavedPoint
import java.util.*

interface QueryPointService {
    fun findSavedPointByCurrentDate(userId: UUID): SavedPoint?
    fun countSavedPointByCurrentDate(userId: UUID): Int
}