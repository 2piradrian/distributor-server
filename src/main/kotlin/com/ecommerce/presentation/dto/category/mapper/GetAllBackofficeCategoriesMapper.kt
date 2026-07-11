package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.GetAllBackofficeCategoriesReq
import com.ecommerce.presentation.dto.category.response.GetAllBackofficeCategoriesRes

object GetAllBackofficeCategoriesMapper {

    fun toRequest(user: User?): GetAllBackofficeCategoriesReq {
        return GetAllBackofficeCategoriesReq(user = user)
    }

    fun toResponse(categories: List<Category>): GetAllBackofficeCategoriesRes {
        return GetAllBackofficeCategoriesRes(categories = categories)
    }

}
