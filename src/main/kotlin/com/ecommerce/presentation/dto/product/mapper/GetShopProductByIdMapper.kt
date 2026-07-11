package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.GetShopProductByIdReq
import com.ecommerce.presentation.dto.product.response.GetShopProductByIdRes
import com.ecommerce.domain.entity.Product

object GetShopProductByIdMapper {

    fun toRequest(id: String): GetShopProductByIdReq {
        return GetShopProductByIdReq(id = id)
    }

    fun toResponse(product: Product): GetShopProductByIdRes {
        return GetShopProductByIdRes(product = product)
    }

}
