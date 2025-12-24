package com.distributor.presentation.dto.user.mapper

import com.distributor.presentation.dto.user.request.CreateUserReq
import com.distributor.presentation.dto.user.response.CreateUserRes

object CreateUserMapper {
    fun toResponse(id: String?): CreateUserRes {
        return CreateUserRes(id)
    }

    fun toRequest(token: String, payload: Map<String, Any>): CreateUserReq {
        return CreateUserReq.build(
            token,
            payload["username"] as? String,
            payload["password"] as? String,
            payload["role"] as? String
        )
    }
}