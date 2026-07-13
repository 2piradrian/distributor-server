package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.GetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.GetCategoryByIdRes

object GetCategoryByIdMapper {

    fun toRequest(user: User?, id: String): GetCategoryByIdReq {
        return GetCategoryByIdReq(user = user, id = id)
    }

    fun toResponse(category: Category): GetCategoryByIdRes {
        return GetCategoryByIdRes(category = category)
    }

}
