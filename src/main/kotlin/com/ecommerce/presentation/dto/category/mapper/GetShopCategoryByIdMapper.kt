package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.GetShopCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.GetShopCategoryByIdRes

object GetShopCategoryByIdMapper {

    fun toRequest(id: String): GetShopCategoryByIdReq {
        return GetShopCategoryByIdReq(id = id)
    }

    fun toResponse(category: Category): GetShopCategoryByIdRes {
        return GetShopCategoryByIdRes(category = category)
    }

}
