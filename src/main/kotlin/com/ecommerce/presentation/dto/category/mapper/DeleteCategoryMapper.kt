package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.presentation.dto.category.request.DeleteCategoryReq

object DeleteCategoryMapper {

    fun toRequest(
        token: String,
        id: String
    ): DeleteCategoryReq {
        return DeleteCategoryReq(
            token = token,
            id = id
        )
    }

}
