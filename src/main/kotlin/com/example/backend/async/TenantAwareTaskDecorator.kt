package com.example.backend.async

import com.example.backend.core.ThreadLocalStorage
import org.springframework.core.task.TaskDecorator

class TenantAwareTaskDecorator : TaskDecorator {
  override fun decorate(runnable: Runnable): Runnable {
    val tenantName: String = ThreadLocalStorage.getTenantName()
    return Runnable {
      try {
        ThreadLocalStorage.setTenantName(tenantName)
        runnable.run()
      } finally {
        ThreadLocalStorage.setTenantName("")
      }
    }
  }
}
