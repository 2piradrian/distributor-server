package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.entity.User
import com.ecommerce.domain.filters.ProductFilters

data class GetAllProductsReq(
    val user: User?,
    val filters: ProductFilters? = null
)
