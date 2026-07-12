package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.filters.ProductFilters

data class ShopGetAllProductsReq(
    val filters: ProductFilters? = null
)
