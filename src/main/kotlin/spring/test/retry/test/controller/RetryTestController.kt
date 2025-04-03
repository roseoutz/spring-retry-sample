package spring.test.retry.test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import spring.test.retry.test.service.RetryTestService

@RestController
class RetryTestController(
    private val retryTestService: RetryTestService
) {

    @GetMapping("/retry/{isRetry}")
    fun retry(
        @PathVariable("isRetry") isRetry: Boolean
    ) {
        retryTestService.retryTest(isRetry)
    }

}