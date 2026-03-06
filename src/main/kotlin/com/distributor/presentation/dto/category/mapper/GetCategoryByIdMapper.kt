package com.distributor.presentation.dto.category.mapper

import com.distributor.domain.entity.Category
import com.distributor.presentation.dto.category.request.GetCategoryByIdReq
import com.distributor.presentation.dto.category.response.GetCategoryByIdRes

object GetCategoryByIdMapper {

    fun toResponse(category: Category): GetCategoryByIdRes {
        return GetCategoryByIdRes(
            category = category
        )
    }

    fun toRequest(token: String, id: String?): GetCategoryByIdReq {
        return GetCategoryByIdReq.build(
            token = token,
            id = id
        )
    }

}
