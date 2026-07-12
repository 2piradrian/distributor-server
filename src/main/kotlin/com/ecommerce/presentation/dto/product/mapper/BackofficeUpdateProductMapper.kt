package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.BackofficeUpdateProductReq
import com.ecommerce.presentation.dto.product.response.BackofficeUpdateProductRes

object BackofficeUpdateProductMapper {

    fun toRequest(
        user: User?,
        id: String,
        payload: Map<String, Any>
    ): BackofficeUpdateProductReq {
        return BackofficeUpdateProductReq(
            user = user,
            id = id,
            name = payload["name"] as? String,
            description = payload["description"] as? String,
            price = (payload["price"] as? Number)?.toDouble(),
            offerPrice = (payload["offerPrice"] as? Number)?.toDouble(),
            stock = (payload["stock"] as? Number)?.toInt(),
            categoryId = payload["categoryId"] as? String,
            mainImage = payload["mainImage"] as? String,
            images = (payload["images"] as? List<*>)?.filterIsInstance<String>() ?: emptyList(),
            isVisible = payload["isVisible"] as? Boolean
        )
    }

    fun toResponse(
        id: String
    ): BackofficeUpdateProductRes {
        return BackofficeUpdateProductRes(
            id = id
        )
    }

}
