package com.distributor.presentation.dto.user.mapper

import com.distributor.presentation.dto.user.request.CreateUserReq
import com.distributor.presentation.dto.user.response.CreateUserRes

object CreateUserMapper {

    fun toResponse(id: String): CreateUserRes {
        return CreateUserRes(
            id = id
        )
    }

    fun toRequest(token: String, payload: Map<String, Any>): CreateUserReq {
        return CreateUserReq.build(
            token = token,
            username = payload["username"] as? String,
            password = payload["password"] as? String,
            role = payload["role"] as? String
        )
    }

}