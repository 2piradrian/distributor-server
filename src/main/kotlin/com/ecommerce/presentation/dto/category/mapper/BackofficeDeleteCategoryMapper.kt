package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.BackofficeDeleteCategoryReq

object BackofficeDeleteCategoryMapper {

    fun toRequest(
        user: User?,
        id: String
    ): BackofficeDeleteCategoryReq {
        return BackofficeDeleteCategoryReq(
            user = user,
            id = id
        )
    }

}
