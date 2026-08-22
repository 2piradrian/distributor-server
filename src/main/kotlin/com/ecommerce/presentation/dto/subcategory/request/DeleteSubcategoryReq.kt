package com.ecommerce.presentation.dto.subcategory.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank

data class DeleteSubcategoryReq(
    val user: User?,

    @field:NotBlank
    val id: String?
)
