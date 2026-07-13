package com.ecommerce.presentation.dto.catalog.response

import com.ecommerce.domain.entity.Product

data class GetProductCatalogRes(
    val products: List<Product>
)
