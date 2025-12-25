package com.distributor.presentation.dto.user.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class GetUserByIdReq(
    val token: String,
    val id: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?
        ): GetUserByIdReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return GetUserByIdReq(
                token,
                id
            )
        }
    }
}
