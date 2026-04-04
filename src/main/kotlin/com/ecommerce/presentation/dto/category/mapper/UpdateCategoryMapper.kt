package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.presentation.dto.category.request.UpdateCategoryReq
import com.ecommerce.presentation.dto.category.response.UpdateCategoryRes

object UpdateCategoryMapper {

    fun toRequest(
        token: String,
        id: String,
        payload: Map<String, Any>
    ): UpdateCategoryReq {
        return UpdateCategoryReq(
            token = token,
            id = id,
            name = payload["name"] as? String
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
