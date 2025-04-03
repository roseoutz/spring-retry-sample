package spring.test.retry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringRetrySampleApplication

fun main(args: Array<String>) {
    runApplication<SpringRetrySampleApplication>(*args)
}
