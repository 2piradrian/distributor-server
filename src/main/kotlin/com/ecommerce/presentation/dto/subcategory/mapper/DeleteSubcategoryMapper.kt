package com.ecommerce.presentation.dto.subcategory.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.subcategory.request.DeleteSubcategoryReq

object DeleteSubcategoryMapper {

    fun toRequest(
        user: User?,
        id: String
    ): DeleteSubcategoryReq {
        return DeleteSubcategoryReq(
            user = user,
            id = id
        )
    }

}
