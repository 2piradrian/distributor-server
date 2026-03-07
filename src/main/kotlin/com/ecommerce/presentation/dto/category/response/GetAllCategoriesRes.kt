package com.ecommerce.presentation.dto.category.response

import com.ecommerce.domain.entity.Category

data class GetAllCategoriesRes(
    val categories: List<Category>
)
