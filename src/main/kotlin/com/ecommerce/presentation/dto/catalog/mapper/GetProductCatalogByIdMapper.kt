package com.ecommerce.presentation.dto.catalog.mapper

import com.ecommerce.presentation.dto.catalog.request.GetProductCatalogByIdReq
import com.ecommerce.presentation.dto.catalog.response.GetProductCatalogByIdRes
import com.ecommerce.domain.entity.Product

object GetProductCatalogByIdMapper {

    fun toRequest(id: String): GetProductCatalogByIdReq {
        return GetProductCatalogByIdReq(id = id)
    }

    fun toResponse(product: Product): GetProductCatalogByIdRes {
        return GetProductCatalogByIdRes(product = product)
    }

}
