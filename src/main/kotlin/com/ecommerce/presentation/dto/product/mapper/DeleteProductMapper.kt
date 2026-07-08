package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.DeleteProductReq

object DeleteProductMapper {

    fun toRequest(
        user: User?,
        id: String
    ): DeleteProductReq {
        return DeleteProductReq(
            user = user,
            id = id
        )
    }

}
