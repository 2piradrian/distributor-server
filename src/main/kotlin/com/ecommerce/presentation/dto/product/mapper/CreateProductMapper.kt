package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.CreateProductReq
import com.ecommerce.presentation.dto.product.response.CreateProductRes

object CreateProductMapper {

    fun toRequest(
        token: String,
        payload: Map<String, Any>
    ): CreateProductReq {
        return CreateProductReq(
            token = token,
            name = payload["name"] as String,
            description = payload["description"] as String,
            price = (payload["price"] as Number).toDouble(),
            stock = (payload["stock"] as Number).toInt(),
            categoryId = payload["categoryId"] as String,
            mainImage = payload["mainImage"] as String,
            images = (payload["images"] as List<*>).filterIsInstance<String>(),
            isVisible = payload["isVisible"] as Boolean
        )
    }

    fun toResponse(
        id: String
    ): CreateProductRes {
        return CreateProductRes(
            id = id
        )
    }

}
