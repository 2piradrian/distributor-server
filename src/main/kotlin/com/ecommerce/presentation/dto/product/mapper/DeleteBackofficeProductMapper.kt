package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.DeleteBackofficeProductReq

object DeleteBackofficeProductMapper {

    fun toRequest(
        user: User?,
        id: String
    ): DeleteBackofficeProductReq {
        return DeleteBackofficeProductReq(
            user = user,
            id = id
        )
    }

}
