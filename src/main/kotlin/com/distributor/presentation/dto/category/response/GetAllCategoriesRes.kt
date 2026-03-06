package com.distributor.presentation.dto.category.response

import com.distributor.domain.entity.Category

data class GetAllCategoriesRes(
    val categories: List<Category>
)
