package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType

data class UpdateProductReq(
    val token: String,
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,
    val categoryId: String
) {
    companion object {
        fun build(
            token: String?,
            id: String?,
            name: String?,
            description: String?,
            price: Double?,
            stock: Int?,
            categoryId: String?
        ): UpdateProductReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty() || name.isNullOrEmpty() || description.isNullOrEmpty() || categoryId.isNullOrEmpty() || price == null || stock == null) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return UpdateProductReq(
                token,
                id,
                name,
                description,
                price,
                stock,
                categoryId
            )
        }
    }
}
