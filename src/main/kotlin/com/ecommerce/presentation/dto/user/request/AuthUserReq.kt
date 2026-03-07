package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

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
