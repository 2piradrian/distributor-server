package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.ShopGetProductByIdReq
import com.ecommerce.presentation.dto.product.response.ShopGetProductByIdRes
import com.ecommerce.domain.entity.Product

object ShopGetProductByIdMapper {

    fun toRequest(id: String): ShopGetProductByIdReq {
        return ShopGetProductByIdReq(id = id)
    }

    fun toResponse(product: Product): ShopGetProductByIdRes {
        return ShopGetProductByIdRes(product = product)
    }

}
