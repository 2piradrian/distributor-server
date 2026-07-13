package com.ecommerce.presentation.dto.catalog.mapper

import com.ecommerce.domain.entity.Category
import com.ecommerce.presentation.dto.catalog.request.GetCategoryCatalogReq
import com.ecommerce.presentation.dto.catalog.response.GetCategoryCatalogRes

object GetCategoryCatalogMapper {

    fun toRequest(): GetCategoryCatalogReq {
        return GetCategoryCatalogReq()
    }

    fun toResponse(categories: List<Category>): GetCategoryCatalogRes {
        return GetCategoryCatalogRes(categories = categories)
    }

}
