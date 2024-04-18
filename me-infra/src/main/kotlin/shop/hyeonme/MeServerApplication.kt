package shop.hyeonme

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeServerApplication

fun main(args: Array<String>) {
    runApplication<MeServerApplication>(*args)
}
