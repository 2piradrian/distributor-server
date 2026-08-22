package com.ecommerce.presentation.dto.subcategory.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.domain.entity.Subcategory
import com.ecommerce.presentation.dto.subcategory.request.GetSubcategoryByIdReq
import com.ecommerce.presentation.dto.subcategory.response.GetSubcategoryByIdRes

object GetSubcategoryByIdMapper {

    fun toRequest(
        user: User?,
        id: String
    ): GetSubcategoryByIdReq {
        return GetSubcategoryByIdReq(
            user = user,
            id = id
        )
    }

    fun toResponse(
        subcategory: Subcategory
    ): GetSubcategoryByIdRes {
        return GetSubcategoryByIdRes(
            subcategory = subcategory
        )
    }

}
