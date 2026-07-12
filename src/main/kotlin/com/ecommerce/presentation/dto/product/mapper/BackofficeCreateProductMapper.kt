package com.ecommerce.presentation.dto.product.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.request.BackofficeCreateProductReq
import com.ecommerce.presentation.dto.product.response.BackofficeCreateProductRes

object BackofficeCreateProductMapper {

    fun toRequest(
        user: User?,
        payload: Map<String, Any>
    ): BackofficeCreateProductReq {
        return BackofficeCreateProductReq(
            user = user,
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
    ): BackofficeCreateProductRes {
        return BackofficeCreateProductRes(
            id = id
        )
    }

}
