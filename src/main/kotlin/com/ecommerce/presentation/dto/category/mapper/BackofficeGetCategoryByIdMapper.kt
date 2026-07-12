package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.request.BackofficeGetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.BackofficeGetCategoryByIdRes

object BackofficeGetCategoryByIdMapper {

    fun toRequest(user: User?, id: String): BackofficeGetCategoryByIdReq {
        return BackofficeGetCategoryByIdReq(user = user, id = id)
    }

    fun toResponse(category: Category): BackofficeGetCategoryByIdRes {
        return BackofficeGetCategoryByIdRes(category = category)
    }

}
