package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class GetAllUserReq(
    val token: String
) {
    companion object {
        fun build(
            token: String?
        ): GetAllUserReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            return GetAllUserReq(
                token
            )
        }
    }
}
