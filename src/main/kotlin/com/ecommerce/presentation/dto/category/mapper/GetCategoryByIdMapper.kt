package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.GetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.GetCategoryByIdRes

object GetCategoryByIdMapper {

    fun toRequest(
        token: String,
        id: String
    ): GetCategoryByIdReq {
        return GetCategoryByIdReq(
            token = token,
            id = id
        )
    }

    fun toResponse(
        category: Category
    ): GetCategoryByIdRes {
        return GetCategoryByIdRes(
            category = category
        )
    }

}
