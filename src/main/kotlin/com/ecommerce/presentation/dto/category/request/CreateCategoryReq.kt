package com.ecommerce.presentation.dto.category.request

import jakarta.validation.constraints.NotBlank

data class CreateCategoryReq(

    @field:NotBlank
    val token: String?,

    @field:NotBlank
    val name: String?

)
