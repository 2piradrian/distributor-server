package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.filters.ProductFilters
import com.ecommerce.presentation.dto.product.request.BackofficeGetAllProductsReq
import com.ecommerce.presentation.dto.product.response.BackofficeGetAllProductsRes

object BackofficeGetAllProductsMapper {

    fun toRequest(
        user: User?,
        categoryId: String? = null,
        name: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): BackofficeGetAllProductsReq {
        return BackofficeGetAllProductsReq(
            user = user,
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
    ): BackofficeGetAllProductsRes {
        return BackofficeGetAllProductsRes(
            products = products
        )
    }

}
