package com.ecommerce.presentation.dto.category.request

import com.ecommerce.domain.entity.User

data class GetAllBackofficeCategoriesReq(
    val user: User?
)
