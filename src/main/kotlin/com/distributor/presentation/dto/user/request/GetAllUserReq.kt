package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

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
