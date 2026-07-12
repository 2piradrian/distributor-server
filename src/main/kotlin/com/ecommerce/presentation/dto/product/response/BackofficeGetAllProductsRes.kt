package com.ecommerce.presentation.dto.product.response

import com.ecommerce.domain.entity.Product

data class BackofficeGetAllProductsRes(
    val products: List<Product>
)
