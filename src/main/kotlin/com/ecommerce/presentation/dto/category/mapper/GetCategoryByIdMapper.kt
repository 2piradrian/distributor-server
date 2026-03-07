package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.GetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.GetCategoryByIdRes

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
