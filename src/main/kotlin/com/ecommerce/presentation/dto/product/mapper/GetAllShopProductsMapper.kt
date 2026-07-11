package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.GetAllShopProductsReq
import com.ecommerce.presentation.dto.product.response.GetAllShopProductsRes
import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters

object GetAllShopProductsMapper {

    fun toRequest(
        categoryId: String? = null,
        name: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): GetAllShopProductsReq {
        return GetAllShopProductsReq(
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
    ): GetAllShopProductsRes {
        return GetAllShopProductsRes(
            products = products
        )
    }

}
