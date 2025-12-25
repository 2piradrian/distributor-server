package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class AuthUserReq(
    val token: String
) {
    companion object {
        fun build(
            token: String?
        ): AuthUserReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            return AuthUserReq(
                token
            )
        }
    }
}
