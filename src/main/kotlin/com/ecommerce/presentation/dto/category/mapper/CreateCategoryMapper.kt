package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.CreateCategoryReq
import com.ecommerce.presentation.dto.category.response.CreateCategoryRes

object CreateCategoryMapper {

    fun toRequest(
        user: User?,
        payload: Map<String, Any>
    ): CreateCategoryReq {
        return CreateCategoryReq(
            user = user,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String
        )
    }

    fun toResponse(
        id: String
    ): CreateCategoryRes {
        return CreateCategoryRes(
            id = id
        )
    }

}
