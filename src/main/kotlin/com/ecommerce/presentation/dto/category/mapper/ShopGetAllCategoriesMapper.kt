package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.ShopGetAllCategoriesReq
import com.ecommerce.presentation.dto.category.response.ShopGetAllCategoriesRes

object ShopGetAllCategoriesMapper {

    fun toRequest(): ShopGetAllCategoriesReq {
        return ShopGetAllCategoriesReq()
    }

    fun toResponse(categories: List<Category>): ShopGetAllCategoriesRes {
        return ShopGetAllCategoriesRes(categories = categories)
    }

}
