package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.BackofficeGetProductByIdReq
import com.ecommerce.presentation.dto.product.response.BackofficeGetProductByIdRes

object BackofficeGetProductByIdMapper {

    fun toRequest(user: User?, id: String): BackofficeGetProductByIdReq {
        return BackofficeGetProductByIdReq(user = user, id = id)
    }

    fun toResponse(product: Product): BackofficeGetProductByIdRes {
        return BackofficeGetProductByIdRes(product = product)
    }

}
