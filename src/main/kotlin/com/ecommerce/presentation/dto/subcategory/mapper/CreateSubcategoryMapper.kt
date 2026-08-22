package com.ecommerce.presentation.dto.subcategory.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.subcategory.request.CreateSubcategoryReq
import com.ecommerce.presentation.dto.subcategory.response.CreateSubcategoryRes

object CreateSubcategoryMapper {

    fun toRequest(
        user: User?,
        payload: Map<String, Any>
    ): CreateSubcategoryReq {
        return CreateSubcategoryReq(
            user = user,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String,
            categoryId = payload["categoryId"] as? String
        )
    }

    fun toResponse(
        id: String
    ): CreateSubcategoryRes {
        return CreateSubcategoryRes(
            id = id
        )
    }

}
