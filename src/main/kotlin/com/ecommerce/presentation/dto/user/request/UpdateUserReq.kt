package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class UpdateUserReq(
    val token: String,
    val id: String,
    val username: String,
    val password: String,
    val role: String,
    val status: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?,
            username: String?,
            password: String?,
            role: String?,
            status: String?
        ): UpdateUserReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (username.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (password.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (role.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (status.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return UpdateUserReq(
                token,
                id,
                username,
                password,
                role,
                status
            )
        }
    }
}
