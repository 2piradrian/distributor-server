package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class GetAllCategoriesReq(
    val token: String
) {
    companion object {
        fun build(
            token: String?
        ): GetAllCategoriesReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            return GetAllCategoriesReq(
                token
            )
        }
    }
}
