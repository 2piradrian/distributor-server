package com.distributor.presentation.dto.user.mapper

import com.distributor.domain.entity.Token
import com.distributor.presentation.dto.user.request.LoginUserReq
import com.distributor.presentation.dto.user.response.LoginUserRes

object LoginUserMapper {

    fun toResponse(token: Token): LoginUserRes {
        return LoginUserRes(
            token = token
        )
    }

    fun toRequest(payload: Map<String, Any>): LoginUserReq {
        return LoginUserReq.build(
            username = payload["username"] as? String,
            password = payload["password"] as? String
        )
    }

}