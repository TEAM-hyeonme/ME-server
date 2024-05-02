package shop.hyeonme.global.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import shop.hyeonme.common.spi.SecurityPort
import java.util.*

@Component
class SecurityAdapter : SecurityPort {
    override fun findCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)
}