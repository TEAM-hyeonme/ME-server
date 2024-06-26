package shop.hyeonme.domain.health.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import shop.hyeonme.common.annotation.WebAdapter

@WebAdapter("/health")
class HealthWebAdapter {
    @GetMapping
    fun healthCheck(): ResponseEntity<String> = 
        ResponseEntity.ok("Application is alive!")
}