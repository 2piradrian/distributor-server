package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.Token
import com.ecommerce.presentation.dto.user.request.LoginUserReq
import com.ecommerce.presentation.dto.user.response.LoginUserRes

object LoginUserMapper {

    fun toRequest(
        payload: Map<String, Any>
    ): LoginUserReq {
        return LoginUserReq(
            username = payload["username"] as String,
            password = payload["password"] as String
        )
    }

    fun toResponse(
        token: Token
    ): LoginUserRes {
        return LoginUserRes(
            token = token
        )
    }

}
