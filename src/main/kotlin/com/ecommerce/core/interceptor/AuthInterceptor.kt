package com.ecommerce.core.interceptor

import com.ecommerce.application.service.UserServiceI
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AuthInterceptor(
    private val userService: UserServiceI
) : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {

        val token = request.getHeader("Authorization")
        val user = this.userService.tryAuth(token)

        request.setAttribute("authenticatedUser", user)

        return true
    }
}
