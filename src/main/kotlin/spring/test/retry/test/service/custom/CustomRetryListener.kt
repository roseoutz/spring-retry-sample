package spring.test.retry.test.service.custom

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.RetryListener
import org.springframework.stereotype.Component

// Component 등록 기본값으로 할당 됨
// @Component
class CustomRetryListener: RetryListener {

    private val logger: Logger = LoggerFactory.getLogger(CustomRetryListener::class.java)

    override fun <T : Any?, E : Throwable?> open(context: RetryContext?, callback: RetryCallback<T, E>?): Boolean {
        logger.info("CustomRetryListener open")
        return super.open(context, callback)
    }

    override fun <T : Any?, E : Throwable?> close(
        context: RetryContext?,
        callback: RetryCallback<T, E>?,
        throwable: Throwable?
    ) {
        logger.info("CustomRetryListener close")
        super.close(context, callback, throwable)
    }

    override fun <T : Any?, E : Throwable?> onSuccess(
        context: RetryContext?,
        callback: RetryCallback<T, E>?,
        result: T
    ) {
        logger.info("CustomRetryListener onSuccess")
        super.onSuccess(context, callback, result)
    }

    override fun <T : Any?, E : Throwable?> onError(
        context: RetryContext?,
        callback: RetryCallback<T, E>?,
        throwable: Throwable?
    ) {
        logger.info("CustomRetryListener onError")
        super.onError(context, callback, throwable)
    }



}