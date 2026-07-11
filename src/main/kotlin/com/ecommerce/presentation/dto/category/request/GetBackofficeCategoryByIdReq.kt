package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.entity.User

data class GetBackofficeCategoryByIdReq(
    val user: User?,
    val id: String
)
