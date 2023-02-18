package com.example.backend.infrastructure.core

class ThreadLocalStorage {
    companion object {
        private var tenant = ThreadLocal<String>()

        fun setTenantName(tenantName: String) {
            tenant.set(tenantName)
        }

        fun getTenantName(): String {
            return tenant.get() ?: ""
        }
    }
}
