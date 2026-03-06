package com.distributor.presentation.dto.category.request

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType

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
