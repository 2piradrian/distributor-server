package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.filters.ProductFilters

data class GetAllShopProductsReq(
    val filters: ProductFilters? = null
)
