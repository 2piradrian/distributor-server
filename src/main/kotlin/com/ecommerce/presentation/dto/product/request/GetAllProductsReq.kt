package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.filters.ProductFilters

data class GetAllProductsReq(

    val token: String?,

    val filters: ProductFilters? = null

)
