package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.filters.ProductFilters

data class GetAllProductsReq(
    val token: String,
    val filters: ProductFilters? = null
) {
    companion object {
        fun build(
            token: String?,
            filters: ProductFilters? = null
        ): GetAllProductsReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            return GetAllProductsReq(
                token,
                filters
            )
        }
    }
}
