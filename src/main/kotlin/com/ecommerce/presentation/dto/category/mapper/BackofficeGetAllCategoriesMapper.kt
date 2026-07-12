package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.BackofficeGetAllCategoriesReq
import com.ecommerce.presentation.dto.category.response.BackofficeGetAllCategoriesRes

object BackofficeGetAllCategoriesMapper {

    fun toRequest(user: User?): BackofficeGetAllCategoriesReq {
        return BackofficeGetAllCategoriesReq(user = user)
    }

    fun toResponse(categories: List<Category>): BackofficeGetAllCategoriesRes {
        return BackofficeGetAllCategoriesRes(categories = categories)
    }

}
