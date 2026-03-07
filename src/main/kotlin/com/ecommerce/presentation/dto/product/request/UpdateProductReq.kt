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
    val categoryId: String,
    val mainImage: String?,
    val images: List<String>,
    val isVisible: Boolean
) {
    companion object {
        fun build(
            token: String?,
            id: String?,
            name: String?,
            description: String?,
            price: Double?,
            stock: Int?,
            categoryId: String?,
            mainImage: String?,
            images: List<String>?,
            isVisible: Boolean?
        ): UpdateProductReq {

            if (token.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.UNAUTHORIZED)
            }

            if (id.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (name.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (description.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (categoryId.isNullOrEmpty()) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (price == null) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (stock == null) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            if (isVisible == null) {
                throw ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS)
            }

            return UpdateProductReq(
                token,
                id,
                name,
                description,
                price,
                stock,
                categoryId,
                mainImage,
                images ?: emptyList(),
                isVisible
            )
        }
    }
}
