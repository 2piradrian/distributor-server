package com.ecommerce.presentation.dto.subcategory.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.subcategory.request.UpdateSubcategoryReq
import com.ecommerce.presentation.dto.subcategory.response.UpdateSubcategoryRes

object UpdateSubcategoryMapper {

    fun toRequest(
        user: User?,
        id: String,
        payload: Map<String, Any>
    ): UpdateSubcategoryReq {
        return UpdateSubcategoryReq(
            user = user,
            id = id,
            name = payload["name"] as? String,
            slug = payload["slug"] as? String,
            categoryId = payload["categoryId"] as? String
        )
    }

    fun toResponse(
        id: String
    ): UpdateSubcategoryRes {
        return UpdateSubcategoryRes(
            id = id
        )
    }

}
