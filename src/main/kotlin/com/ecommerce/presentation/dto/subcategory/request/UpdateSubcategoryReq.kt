package com.ecommerce.presentation.dto.subcategory.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class UpdateSubcategoryReq(
    val user: User?,

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    @field:Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$")
    val slug: String?,

    @field:NotBlank
    val categoryId: String?
)
