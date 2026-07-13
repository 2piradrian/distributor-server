package com.ecommerce.presentation.dto.catalog.mapper

import com.ecommerce.presentation.dto.catalog.request.GetProductCatalogReq
import com.ecommerce.presentation.dto.catalog.response.GetProductCatalogRes
import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters

object GetProductCatalogMapper {

    fun toRequest(
        categoryId: String? = null,
        name: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): GetProductCatalogReq {
        return GetProductCatalogReq(
            filters = ProductFilters(
                categoryId = categoryId,
                name = name,
                minPrice = minPrice,
                maxPrice = maxPrice
            )
        )
    }

    fun toResponse(
        products: List<Product>
    ): GetProductCatalogRes {
        return GetProductCatalogRes(
            products = products
        )
    }

}
