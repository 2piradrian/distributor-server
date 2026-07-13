package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank

data class CreateCategoryReq(

    val user: User?,

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val slug: String?

)
