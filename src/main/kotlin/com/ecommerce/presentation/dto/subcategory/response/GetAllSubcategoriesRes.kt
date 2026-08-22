package com.ecommerce.presentation.dto.subcategory.response

import com.ecommerce.domain.entity.Subcategory

data class GetAllSubcategoriesRes(
    val subcategories: List<Subcategory>
)
