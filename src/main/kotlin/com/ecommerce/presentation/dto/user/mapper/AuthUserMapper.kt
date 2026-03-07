package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.AuthUserReq
import com.ecommerce.presentation.dto.user.response.AuthUserRes

object AuthUserMapper {

    fun toResponse(user: User): AuthUserRes {
        return AuthUserRes(
            id = user.id!!,
            username = user.username,
            role = user.role
        )
    }

    fun toRequest(token: String): AuthUserReq {
        return AuthUserReq.build(
            token = token
        )
    }
}