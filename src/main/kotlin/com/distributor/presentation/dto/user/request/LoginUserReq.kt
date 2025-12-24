package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class LoginUserReq(
    val username: String,
    val password: String
) {
    companion object {
        fun build(username: String?, password: String?): LoginUserReq {
            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }
            if (password.length < 8) {
                throw ErrorHandler(ErrorType.INVALID_FIELDS)
            }
            return LoginUserReq(username, password)
        }
    }
}
