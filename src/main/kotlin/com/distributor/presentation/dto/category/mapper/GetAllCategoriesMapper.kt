package com.distributor.presentation.dto.category.mapper

import com.distributor.domain.entity.Category
import com.distributor.presentation.dto.category.request.GetAllCategoriesReq
import com.distributor.presentation.dto.category.response.GetAllCategoriesRes

object GetAllCategoriesMapper {

    fun toResponse(categories: List<Category>): GetAllCategoriesRes {
        return GetAllCategoriesRes(
            categories = categories
        )
    }

    fun toRequest(token: String): GetAllCategoriesReq {
        return GetAllCategoriesReq.build(
            token = token
        )
    }

}
