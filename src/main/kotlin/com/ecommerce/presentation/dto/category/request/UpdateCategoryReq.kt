package com.ecommerce.presentation.dto.category.request

import jakarta.validation.constraints.NotBlank

data class UpdateCategoryReq(

    @field:NotBlank
    val token: String?,

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val slug: String?

)
