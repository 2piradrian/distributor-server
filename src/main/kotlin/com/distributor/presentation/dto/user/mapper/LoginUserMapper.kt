package com.distributor.presentation.dto.user.mapper

import com.distributor.domain.entity.Token
import com.distributor.presentation.dto.user.request.LoginUserReq
import com.distributor.presentation.dto.user.response.LoginUserRes

object LoginUserMapper {
    fun toResponse(token: Token): LoginUserRes {
        return LoginUserRes(token)
    }

    fun toRequest(payload: Map<String, Any>): LoginUserReq {
        return LoginUserReq.build(
            payload["username"] as? String,
            payload["password"] as? String
        )
    }
}