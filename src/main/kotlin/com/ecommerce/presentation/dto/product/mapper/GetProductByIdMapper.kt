package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.presentation.dto.product.request.GetProductByIdReq
import com.ecommerce.presentation.dto.product.response.GetProductByIdRes

object GetProductByIdMapper {

    fun toRequest(token: String, id: String): GetProductByIdReq {
        return GetProductByIdReq.build(
            token = token,
            id = id
        )
    }

    fun toResponse(product: Product): GetProductByIdRes {
        return GetProductByIdRes(product)
    }
}
