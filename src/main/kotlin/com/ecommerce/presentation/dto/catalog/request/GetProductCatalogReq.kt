package com.ecommerce.presentation.dto.catalog.request

import com.ecommerce.domain.filters.ProductFilters

data class GetProductCatalogReq(
    val filters: ProductFilters
)
