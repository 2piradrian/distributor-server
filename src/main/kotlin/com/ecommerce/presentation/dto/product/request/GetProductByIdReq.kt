package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class GetProductByIdReq(
    val token: String?,
    val id: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?
        ): GetProductByIdReq {

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return GetProductByIdReq(
                token,
                id
            )
        }
    }
}
