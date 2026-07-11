package com.ecommerce.presentation.dto.category.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.category.request.GetAllShopCategoriesReq
import com.ecommerce.presentation.dto.category.response.GetAllShopCategoriesRes

object GetAllShopCategoriesMapper {

    fun toRequest(): GetAllShopCategoriesReq {
        return GetAllShopCategoriesReq()
    }

    fun toResponse(categories: List<Category>): GetAllShopCategoriesRes {
        return GetAllShopCategoriesRes(categories = categories)
    }

}
