package shop.hyeonme.me.domain.health.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import shop.hyeonme.me.common.annotation.RequestController

@RequestController("/health")
class HealthController {
    @GetMapping
    fun healthCheck(): ResponseEntity<String> = 
        ResponseEntity.ok("Application is alive!")
}