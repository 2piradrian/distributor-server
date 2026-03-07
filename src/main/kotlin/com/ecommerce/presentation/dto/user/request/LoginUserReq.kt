package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class LoginUserReq(
    val username: String,
    val password: String
) {
    companion object {
        fun build(username: String?, password: String?): LoginUserReq {
            
            if (username.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (password.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (password.length < 8) {
                throw ErrorHandler(ErrorType.INVALID_FIELDS)
            }

            return LoginUserReq(username, password)
        }
    }
}
