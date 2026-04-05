package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.presentation.dto.category.request.CreateCategoryReq
import com.ecommerce.presentation.dto.category.response.CreateCategoryRes

object CreateCategoryMapper {

    fun toRequest(
        token: String,
        payload: Map<String, Any>
    ): CreateCategoryReq {
        return CreateCategoryReq(
            token = token,
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
