package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class CreateUserReq(
    val token: String,
    val username: String,
    val password: String,
    val role: String
) {
    companion object {
        fun build(
            token: String?,
            username: String?,
            password: String?,
            role: String?
        ): CreateUserReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (username.isNullOrEmpty() || password.isNullOrEmpty() || role.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return CreateUserReq(
                token,
                username,
                password,
                role
            )
        }
    }
}
