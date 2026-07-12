package com.ecommerce.presentation.dto.product.request

import com.ecommerce.domain.entity.User

data class BackofficeGetProductByIdReq(
    val user: User?,
    val id: String
)
