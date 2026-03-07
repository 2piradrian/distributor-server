package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.presentation.dto.product.request.UpdateProductReq
import com.ecommerce.presentation.dto.product.response.UpdateProductRes

object UpdateProductMapper {

    fun toRequest(token: String, id: String, payload: Map<String, Any>): UpdateProductReq {
        return UpdateProductReq.build(
            token = token,
            id = id,
            name = payload["name"] as? String,
            description = payload["description"] as? String,
            price = (payload["price"] as? Number)?.toDouble(),
            stock = (payload["stock"] as? Number)?.toInt(),
            categoryId = payload["categoryId"] as? String,
            mainImage = payload["mainImage"] as? String,
            images = (payload["images"] as? List<*>)?.filterIsInstance<String>(),
            isVisible = payload["isVisible"] as? Boolean
        )
    }

    fun toResponse(id: String): UpdateProductRes {
        return UpdateProductRes(id)
    }
}
