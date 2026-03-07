package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class CreateProductReq(
    val token: String,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,
    val categoryId: String
) {
    companion object {
        fun build(
            token: String?,
            name: String?,
            description: String?,
            price: Double?,
            stock: Int?,
            categoryId: String?
        ): CreateProductReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (name.isNullOrEmpty() || description.isNullOrEmpty() || categoryId.isNullOrEmpty() || price == null || stock == null) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return CreateProductReq(
                token,
                name,
                description,
                price,
                stock,
                categoryId
            )
        }
    }
}
