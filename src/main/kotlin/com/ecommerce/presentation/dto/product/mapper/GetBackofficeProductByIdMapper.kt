package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.GetBackofficeProductByIdReq
import com.ecommerce.presentation.dto.product.response.GetBackofficeProductByIdRes

object GetBackofficeProductByIdMapper {

    fun toRequest(user: User?, id: String): GetBackofficeProductByIdReq {
        return GetBackofficeProductByIdReq(user = user, id = id)
    }

    fun toResponse(product: Product): GetBackofficeProductByIdRes {
        return GetBackofficeProductByIdRes(product = product)
    }

}
