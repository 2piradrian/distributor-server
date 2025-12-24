package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

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
            if (id.isNullOrEmpty() || username.isNullOrEmpty() || password.isNullOrEmpty() || role.isNullOrEmpty() || status.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }
            return UpdateUserReq(token, id, username, password, role, status)
        }
    }
}
