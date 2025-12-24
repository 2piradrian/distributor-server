package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class CreateAdminUserReq(
    val secret: String,
    val username: String,
    val password: String
) {
    companion object {
        fun build(secret: String?, username: String?, password: String?): CreateAdminUserReq {
            if (secret.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }
            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }
            return CreateAdminUserReq(secret, username, password)
        }
    }
}
