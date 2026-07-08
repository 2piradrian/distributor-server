package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.DeleteCategoryReq

object DeleteCategoryMapper {

    fun toRequest(
        user: User?,
        id: String
    ): DeleteCategoryReq {
        return DeleteCategoryReq(
            user = user,
            id = id
        )
    }

}
