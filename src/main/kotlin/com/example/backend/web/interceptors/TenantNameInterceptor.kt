package com.example.backend.web.interceptors

import com.example.backend.core.ThreadLocalStorage
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TenantNameInterceptor : HandlerInterceptor {
    @Throws(Exception::class)
    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        val tenantName: String = request.getHeader("X-TenantID")
        ThreadLocalStorage.setTenantName(tenantName)

        return true
    }

    @Throws(Exception::class)
    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        ThreadLocalStorage.setTenantName("")
    }
}
