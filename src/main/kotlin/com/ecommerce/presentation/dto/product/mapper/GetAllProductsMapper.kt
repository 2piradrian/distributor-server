package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters
import com.ecommerce.presentation.dto.product.request.GetAllProductsReq
import com.ecommerce.presentation.dto.product.response.GetAllProductsRes

object GetAllProductsMapper {

    fun toRequest(
        token: String?,
        categoryId: String? = null,
        name: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): GetAllProductsReq {
        return GetAllProductsReq.build(
            token = token,
            filters = ProductFilters(
                categoryId = categoryId,
                name = name,
                minPrice = minPrice,
                maxPrice = maxPrice
            )
        )
    }

    fun toResponse(products: List<Product>): GetAllProductsRes {
        return GetAllProductsRes(products)
    }
}
