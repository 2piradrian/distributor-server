package com.ecommerce.presentation.dto.catalog.response

import com.ecommerce.domain.entity.Category

data class GetCategoryCatalogRes(
    val categories: List<Category>
)
