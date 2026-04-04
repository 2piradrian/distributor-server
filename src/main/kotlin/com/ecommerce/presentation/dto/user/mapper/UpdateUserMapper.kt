package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.presentation.dto.user.request.UpdateUserReq
import com.ecommerce.presentation.dto.user.response.UpdateUserRes

object UpdateUserMapper {

    fun toRequest(
        token: String,
        id: String,
        payload: Map<String, Any>
    ): UpdateUserReq {
        return UpdateUserReq(
            token = token,
            id = id,
            username = payload["username"] as? String,
            password = payload["password"] as? String,
            role = payload["role"] as? String,
            status = payload["status"] as? String
        )
    }

    fun toResponse(
        id: String
    ): UpdateUserRes {
        return UpdateUserRes(
            id = id
        )
    }

}
