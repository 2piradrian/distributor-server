package com.ecommerce.presentation.dto.product.response

import com.ecommerce.domain.entity.Product

data class ShopGetAllProductsRes(
    val products: List<Product>
)
