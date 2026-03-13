package com.ecommerce.presentation.dto.category.request

import jakarta.validation.constraints.NotBlank

data class DeleteCategoryReq(

    @field:NotBlank
    val token: String,

    @field:NotBlank
    val id: String,

)
