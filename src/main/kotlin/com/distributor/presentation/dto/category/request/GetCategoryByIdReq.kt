package com.distributor.presentation.dto.category.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class GetCategoryByIdReq(
    val token: String,
    val id: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?
        ): GetCategoryByIdReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return GetCategoryByIdReq(
                token,
                id
            )
        }
    }
}
