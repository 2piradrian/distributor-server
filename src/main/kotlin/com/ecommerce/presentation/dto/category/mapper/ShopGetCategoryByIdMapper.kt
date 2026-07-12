package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.ShopGetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.ShopGetCategoryByIdRes

object ShopGetCategoryByIdMapper {

    fun toRequest(id: String): ShopGetCategoryByIdReq {
        return ShopGetCategoryByIdReq(id = id)
    }

    fun toResponse(category: Category): ShopGetCategoryByIdRes {
        return ShopGetCategoryByIdRes(category = category)
    }

}
