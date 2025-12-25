package com.distributor.presentation.dto.user.mapper

import com.distributor.domain.entity.User
import com.distributor.presentation.dto.user.request.AuthUserReq
import com.distributor.presentation.dto.user.response.AuthUserRes

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