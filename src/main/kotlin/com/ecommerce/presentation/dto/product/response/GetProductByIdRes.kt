package com.ecommerce.presentation.dto.product.response

import com.ecommerce.domain.entity.Product

data class GetProductByIdRes(
    val product: Product
)
