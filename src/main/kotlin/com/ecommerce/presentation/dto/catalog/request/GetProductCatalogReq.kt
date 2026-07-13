package com.ecommerce.presentation.dto.catalog.request

import com.ecommerce.presentation.dto.product.request.ProductFilters

data class GetProductCatalogReq(
    val filters: ProductFilters
)
