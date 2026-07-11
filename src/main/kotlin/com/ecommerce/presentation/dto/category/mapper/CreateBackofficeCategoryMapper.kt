package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.CreateBackofficeCategoryReq
import com.ecommerce.presentation.dto.category.response.CreateBackofficeCategoryRes

object CreateBackofficeCategoryMapper {

    fun toRequest(
        user: User?,
        payload: Map<String, Any>
    ): CreateBackofficeCategoryReq {
        return CreateBackofficeCategoryReq(
            user = user,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String
        )
    }

    fun toResponse(
        id: String
    ): CreateBackofficeCategoryRes {
        return CreateBackofficeCategoryRes(
            id = id
        )
    }

}
