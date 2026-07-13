package com.ecommerce.presentation.dto.catalog.response

import com.ecommerce.domain.entity.Product

data class GetProductCatalogByIdRes(
    val product: Product
)
