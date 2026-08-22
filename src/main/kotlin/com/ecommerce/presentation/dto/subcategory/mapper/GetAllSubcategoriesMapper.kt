package com.ecommerce.presentation.dto.subcategory.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.domain.entity.Subcategory
import com.ecommerce.presentation.dto.subcategory.request.GetAllSubcategoriesReq
import com.ecommerce.presentation.dto.subcategory.response.GetAllSubcategoriesRes

object GetAllSubcategoriesMapper {

    fun toRequest(
        user: User?
    ): GetAllSubcategoriesReq {
        return GetAllSubcategoriesReq(
            user = user
        )
    }

    fun toResponse(
        subcategories: List<Subcategory>
    ): GetAllSubcategoriesRes {
        return GetAllSubcategoriesRes(
            subcategories = subcategories
        )
    }

}
