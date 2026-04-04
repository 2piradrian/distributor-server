package com.ecommerce.presentation.dto.product.request

import jakarta.validation.constraints.NotBlank

data class GetProductByIdReq(

    val token: String?,

    @field:NotBlank
    val id: String?

)
