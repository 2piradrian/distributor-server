package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.UpdateBackofficeCategoryReq
import com.ecommerce.presentation.dto.category.response.UpdateBackofficeCategoryRes

object UpdateBackofficeCategoryMapper {

    fun toRequest(
        user: User?,
        id: String,
        payload: Map<String, Any>
    ): UpdateBackofficeCategoryReq {
        return UpdateBackofficeCategoryReq(
            user = user,
            id = id,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String
        )
    }

    fun toResponse(
        id: String
    ): UpdateBackofficeCategoryRes {
        return UpdateBackofficeCategoryRes(
            id = id
        )
    }

}
