package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class CreateAdminUserReq(
    val secret: String,
    val username: String,
    val password: String
) {
    companion object {
        fun build(
            secret: String?,
            username: String?,
            password: String?
        ): CreateAdminUserReq {

            if (secret.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (username.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (password.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return CreateAdminUserReq(
                secret,
                username,
                password
            )
        }
    }
}
