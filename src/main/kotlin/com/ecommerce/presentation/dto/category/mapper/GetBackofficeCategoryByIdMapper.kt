package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.GetBackofficeCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.GetBackofficeCategoryByIdRes

object GetBackofficeCategoryByIdMapper {

    fun toRequest(user: User?, id: String): GetBackofficeCategoryByIdReq {
        return GetBackofficeCategoryByIdReq(user = user, id = id)
    }

    fun toResponse(category: Category): GetBackofficeCategoryByIdRes {
        return GetBackofficeCategoryByIdRes(category = category)
    }

}
