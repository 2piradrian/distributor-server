package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.UpdateCategoryReq
import com.ecommerce.presentation.dto.category.response.UpdateCategoryRes

object UpdateCategoryMapper {

    fun toRequest(
        user: User?,
        id: String,
        payload: Map<String, Any>
    ): UpdateCategoryReq {
        return UpdateCategoryReq(
            user = user,
            id = id,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String
        )
    }

    fun toResponse(
        id: String
    ): UpdateCategoryRes {
        return UpdateCategoryRes(
            id = id
        )
    }

}
