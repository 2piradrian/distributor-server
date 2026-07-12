package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank

data class BackofficeDeleteProductReq(

    val user: User?,

    @field:NotBlank
    val id: String?

)
