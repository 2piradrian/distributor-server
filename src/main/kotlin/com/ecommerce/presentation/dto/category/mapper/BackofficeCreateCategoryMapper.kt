package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.BackofficeCreateCategoryReq
import com.ecommerce.presentation.dto.category.response.BackofficeCreateCategoryRes

object BackofficeCreateCategoryMapper {

    fun toRequest(
        user: User?,
        payload: Map<String, Any>
    ): BackofficeCreateCategoryReq {
        return BackofficeCreateCategoryReq(
            user = user,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String
        )
    }

    fun toResponse(
        id: String
    ): BackofficeCreateCategoryRes {
        return BackofficeCreateCategoryRes(
            id = id
        )
    }

}
