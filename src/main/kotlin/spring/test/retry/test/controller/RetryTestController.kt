package spring.test.retry.test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import spring.test.retry.test.service.annotated.AnnotatedRetryTestService
import spring.test.retry.test.service.custom.CustomRetryTestService

@RestController
class RetryTestController(
    private val annotatedRetryTestService: AnnotatedRetryTestService,
    private val customRetryTestService: CustomRetryTestService
) {

    @GetMapping("/retry/annotated/{isRetry}")
    fun annotatedRetry(
        @PathVariable("isRetry") isRetry: Boolean
    ) {
        annotatedRetryTestService.retryTest(isRetry)
    }


    @GetMapping("/retry/custom/{isRetry}")
    fun customRetry(
        @PathVariable("isRetry") isRetry: Boolean
    ) {
        customRetryTestService.retryTest(isRetry)
    }

}