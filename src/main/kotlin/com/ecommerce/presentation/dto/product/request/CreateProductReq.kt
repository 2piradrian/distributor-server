package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
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

    @field:Positive
    val offerPrice: Double?,

    @field:NotNull
    val stock: Int,

    @field:NotBlank
    val categoryId: String,

    val mainImage: String?,

    val images: List<String> = emptyList(),

    @field:NotNull
    val isVisible: Boolean

) {}