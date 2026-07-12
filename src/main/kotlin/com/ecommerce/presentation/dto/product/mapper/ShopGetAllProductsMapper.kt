package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.ShopGetAllProductsReq
import com.ecommerce.presentation.dto.product.response.ShopGetAllProductsRes
import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters

object ShopGetAllProductsMapper {

    fun toRequest(
        categoryId: String? = null,
        name: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): ShopGetAllProductsReq {
        return ShopGetAllProductsReq(
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
    ): ShopGetAllProductsRes {
        return ShopGetAllProductsRes(
            products = products
        )
    }

}
