package com.example.backend.async

import java.util.concurrent.Executor
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurerSupport
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class AsyncConfig : AsyncConfigurerSupport() {
  override fun getAsyncExecutor(): Executor {
    val executor: ThreadPoolTaskExecutor = ThreadPoolTaskExecutor()

    executor.setCorePoolSize(7)
    executor.setMaxPoolSize(42)
    executor.setQueueCapacity(11)
    executor.setThreadNamePrefix("TenantAwareTaskExecutor-")
    executor.setTaskDecorator(TenantAwareTaskDecorator())
    executor.initialize()

    return executor
  }
}
