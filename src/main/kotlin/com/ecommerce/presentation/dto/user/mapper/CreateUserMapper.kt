package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.presentation.dto.user.request.CreateUserReq
import com.ecommerce.presentation.dto.user.response.CreateUserRes

object CreateUserMapper {

    fun toRequest(
        token: String,
        payload: Map<String, Any>
    ): CreateUserReq {
        return CreateUserReq(
            token = token,
            username = payload["username"] as? String,
            password = payload["password"] as? String,
            role = payload["role"] as? String
        )
    }

    fun toResponse(
        id: String
    ): CreateUserRes {
        return CreateUserRes(
            id = id
        )
    }

}
