package com.distributor.presentation.dto.category.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

data class CreateCategoryReq(
    val token: String,
    val name: String
) {
    companion object {
        fun build(
            token: String?,
            name: String?
        ): CreateCategoryReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (name.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return CreateCategoryReq(
                token,
                name
            )
        }
    }
}
