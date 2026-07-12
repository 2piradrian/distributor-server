package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.BackofficeDeleteProductReq

object BackofficeDeleteProductMapper {

    fun toRequest(
        user: User?,
        id: String
    ): BackofficeDeleteProductReq {
        return BackofficeDeleteProductReq(
            user = user,
            id = id
        )
    }

}
