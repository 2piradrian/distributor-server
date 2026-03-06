package com.distributor.presentation.dto.category.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class DeleteCategoryReq(
    val token: String,
    val id: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?
        ): DeleteCategoryReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return DeleteCategoryReq(
                token,
                id
            )
        }
    }
}
