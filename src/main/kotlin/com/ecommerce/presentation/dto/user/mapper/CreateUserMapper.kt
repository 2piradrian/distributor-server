package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.CreateUserReq
import com.ecommerce.presentation.dto.user.response.CreateUserRes

object CreateUserMapper {

    fun toRequest(
        user: User?,
        payload: Map<String, Any>
    ): CreateUserReq {
        return CreateUserReq(
            user = user,
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
