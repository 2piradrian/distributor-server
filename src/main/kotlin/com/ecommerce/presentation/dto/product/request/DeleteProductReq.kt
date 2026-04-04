package com.ecommerce.presentation.dto.product.request

import jakarta.validation.constraints.NotBlank

data class DeleteProductReq(

    @field:NotBlank
    val token: String?,

    @field:NotBlank
    val id: String?,

)
