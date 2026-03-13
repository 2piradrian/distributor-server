package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.GetAllCategoriesReq
import com.ecommerce.presentation.dto.category.response.GetAllCategoriesRes

object GetAllCategoriesMapper {

    fun toRequest(
        token: String?
    ): GetAllCategoriesReq {
        return GetAllCategoriesReq(
            token = token
        )
    }

    fun toResponse(
        categories: List<Category>
    ): GetAllCategoriesRes {
        return GetAllCategoriesRes(
            categories = categories
        )
    }

}
