package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.BackofficeUpdateCategoryReq
import com.ecommerce.presentation.dto.category.response.BackofficeUpdateCategoryRes

object BackofficeUpdateCategoryMapper {

    fun toRequest(
        user: User?,
        id: String,
        payload: Map<String, Any>
    ): BackofficeUpdateCategoryReq {
        return BackofficeUpdateCategoryReq(
            user = user,
            id = id,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String
        )
    }

    fun toResponse(
        id: String
    ): BackofficeUpdateCategoryRes {
        return BackofficeUpdateCategoryRes(
            id = id
        )
    }

}
