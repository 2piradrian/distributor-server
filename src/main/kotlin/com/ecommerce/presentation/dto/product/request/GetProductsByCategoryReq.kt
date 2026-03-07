package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class GetProductsByCategoryReq(
    val token: String,
    val categoryId: String
) {
    companion object {
        fun build(
            token: String?,
            categoryId: String?
        ): GetProductsByCategoryReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (categoryId.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return GetProductsByCategoryReq(
                token,
                categoryId
            )
        }
    }
}
