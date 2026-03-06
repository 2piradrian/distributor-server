package com.distributor.presentation.dto.category.mapper

import com.distributor.presentation.dto.category.request.CreateCategoryReq
import com.distributor.presentation.dto.category.response.CreateCategoryRes

object CreateCategoryMapper {

    fun toResponse(id: String): CreateCategoryRes {
        return CreateCategoryRes(
            id = id
        )
    }

    fun toRequest(token: String, payload: Map<String, Any>): CreateCategoryReq {
        return CreateCategoryReq.build(
            token = token,
            name = payload["name"] as? String
        )
    }

}
