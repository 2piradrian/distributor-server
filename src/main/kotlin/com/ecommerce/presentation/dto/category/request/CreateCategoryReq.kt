package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class CreateCategoryReq(

    val user: User?,

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    @field:Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$")
    val slug: String?

)
