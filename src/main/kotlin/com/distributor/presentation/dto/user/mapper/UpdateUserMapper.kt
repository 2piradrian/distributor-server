package com.distributor.presentation.dto.user.mapper

import com.distributor.presentation.dto.user.request.UpdateUserReq
import com.distributor.presentation.dto.user.response.UpdateUserRes

object UpdateUserMapper {

    fun toResponse(id: String): UpdateUserRes {
        return UpdateUserRes(
            id = id
        )
    }

    fun toRequest(token: String, id: String, payload: Map<String, Any>): UpdateUserReq {
        return UpdateUserReq.build(
            token = token,
            id = id,
            username = payload["username"] as? String,
            password = payload["password"] as? String,
            role = payload["role"] as? String,
            status = payload["status"] as? String
        )
    }

}