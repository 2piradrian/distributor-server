package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class UpdateCategoryReq(
    val token: String,
    val id: String,
    val name: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?,
            name: String?
        ): UpdateCategoryReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (name.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return UpdateCategoryReq(
                token,
                id,
                name
            )
        }
    }
}
