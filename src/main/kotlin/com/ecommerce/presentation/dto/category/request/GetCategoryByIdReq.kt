package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank

data class GetCategoryByIdReq(

    val user: User?,

    @field:NotBlank
    val id: String?

)
