package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class GetAllCategoriesReq(
    val token: String?
) {
    companion object {
        fun build(
            token: String?
        ): GetAllCategoriesReq {

            return GetAllCategoriesReq(
                token
            )
        }
    }
}
