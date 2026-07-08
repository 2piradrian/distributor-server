package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.UpdateUserReq
import com.ecommerce.presentation.dto.user.response.UpdateUserRes

object UpdateUserMapper {

    fun toRequest(
        user: User?,
        id: String,
        payload: Map<String, Any>
    ): UpdateUserReq {
        return UpdateUserReq(
            user = user,
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
