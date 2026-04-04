package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.DeleteProductReq

object DeleteProductMapper {

    fun toRequest(
        token: String,
        id: String
    ): DeleteProductReq {
        return DeleteProductReq(
            token = token,
            id = id
        )
    }

}
