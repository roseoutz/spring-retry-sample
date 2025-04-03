package spring.test.retry.test.service.custom

import org.slf4j.LoggerFactory
import org.springframework.retry.RetryContext
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import spring.test.retry.test.NotRetryableException
import spring.test.retry.test.RetryableException
import spring.test.retry.test.service.annotated.AnnotatedRetryTestService

@Service
class CustomRetryTestService {

    private val logger = LoggerFactory.getLogger(AnnotatedRetryTestService::class.java)

    @Retryable(
        maxAttempts = 3, // 최대 실행 회수
        backoff = Backoff(3), // 재시도 사이 간격(초)
        exclude = [NotRetryableException::class], // 포함할 예외 클래스
        // listeners = ["customRetryListener"]
    )
    fun retryTest(isRetry: Boolean) {
        if (isRetry) {
            logger.info("Retrying test")
            throw RetryableException()
        }

        logger.info("Not Retrying test")
        throw NotRetryableException()
    }

    @Recover
    fun recover(e: Exception, retryContext: RetryContext, isRetry: Boolean) {
        logger.info("Recovering exception")
    }
}
