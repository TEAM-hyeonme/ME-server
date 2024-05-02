package shop.hyeonme.common.spi

import java.util.*

interface SecurityPort {
    fun findCurrentUserId(): UUID
}