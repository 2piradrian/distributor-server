package com.distributor.presentation.dto.user.mapper

import com.distributor.presentation.dto.user.request.UpdateUserReq
import com.distributor.presentation.dto.user.response.UpdateUserRes

object UpdateUserMapper {
    fun toResponse(id: String?): UpdateUserRes {
        return UpdateUserRes(id)
    }

    fun toRequest(token: String, id: String, payload: Map<String, Any>): UpdateUserReq {
        return UpdateUserReq.build(
            token,
            id,
            payload["username"] as? String,
            payload["password"] as? String,
            payload["role"] as? String,
            payload["status"] as? String
        )
    }
}