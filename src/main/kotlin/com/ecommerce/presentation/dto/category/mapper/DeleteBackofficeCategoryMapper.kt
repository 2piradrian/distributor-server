package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.DeleteBackofficeCategoryReq

object DeleteBackofficeCategoryMapper {

    fun toRequest(
        user: User?,
        id: String
    ): DeleteBackofficeCategoryReq {
        return DeleteBackofficeCategoryReq(
            user = user,
            id = id
        )
    }

}
