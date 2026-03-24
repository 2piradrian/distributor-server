package com.ecommerce.presentation.dto.product.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class CreateProductReq(

    @field:NotBlank
    val token: String,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val description: String,

    @field:NotNull
    @field:Positive
    val price: Double,
<<<<<<< Updated upstream

    @field:NotNull
=======
    val offerPrice: Double?,
>>>>>>> Stashed changes
    val stock: Int,

    @field:NotBlank
    val categoryId: String,

    val mainImage: String,

    val images: List<String>,
<<<<<<< Updated upstream
=======
    val isVisible: Boolean
) {
    companion object {
        fun build(
            token: String?,
            name: String?,
            description: String?,
            price: Double?,
            offerPrice: Double?,
            stock: Int?,
            categoryId: String?,
            mainImage: String?,
            images: List<String>?,
            isVisible: Boolean?
        ): CreateProductReq {
>>>>>>> Stashed changes

    @field:NotNull
    val isVisible: Boolean,

<<<<<<< Updated upstream
)
=======
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

            return CreateProductReq(
                token,
                name,
                description,
                price,
                offerPrice,
                stock,
                categoryId,
                mainImage,
                images ?: emptyList(),
                isVisible
            )
        }
    }
}
>>>>>>> Stashed changes
