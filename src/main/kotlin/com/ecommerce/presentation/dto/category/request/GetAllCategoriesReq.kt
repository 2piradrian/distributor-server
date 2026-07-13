package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.entity.User

data class GetAllCategoriesReq(
    val user: User?
)
