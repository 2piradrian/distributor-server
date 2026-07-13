package com.ecommerce.presentation.dto.catalog.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.catalog.request.GetCategoryCatalogByIdReq
import com.ecommerce.presentation.dto.catalog.response.GetCategoryCatalogByIdRes

object GetCategoryCatalogByIdMapper {

    fun toRequest(id: String): GetCategoryCatalogByIdReq {
        return GetCategoryCatalogByIdReq(id = id)
    }

    fun toResponse(category: Category): GetCategoryCatalogByIdRes {
        return GetCategoryCatalogByIdRes(category = category)
    }

}
