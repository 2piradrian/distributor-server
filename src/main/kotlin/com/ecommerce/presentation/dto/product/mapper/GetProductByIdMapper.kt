package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.GetProductByIdReq
import com.ecommerce.presentation.dto.product.response.GetProductByIdRes

object GetProductByIdMapper {

    fun toRequest(
        user: User?,
        id: String
    ): GetProductByIdReq {
        return GetProductByIdReq(
            user = user,
            id = id
        )
    }

    fun toResponse(
        product: Product
    ): GetProductByIdRes {
        return GetProductByIdRes(
            product = product
        )
    }

}
