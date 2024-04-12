package shop.hyeonme.me

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class MeServerApplication

fun main(args: Array<String>) {
    runApplication<MeServerApplication>(*args)
}
