package com.ecommerce.presentation.dto.category.response

import com.ecommerce.domain.entity.Category

data class GetAllBackofficeCategoriesRes(
    val categories: List<Category>
)
