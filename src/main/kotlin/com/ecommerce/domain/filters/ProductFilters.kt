package com.ecommerce.domain.filters

data class ProductFilters(
    val categoryId: String? = null,
    val minPrice: Double? = null,
    val maxPrice: Double? = null,
    val name: String? = null
)
