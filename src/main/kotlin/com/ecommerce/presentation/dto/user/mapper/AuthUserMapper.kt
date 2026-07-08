package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.AuthUserReq
import com.ecommerce.presentation.dto.user.response.AuthUserRes

object AuthUserMapper {

    fun toRequest(
        user: User?
    ): AuthUserReq {
        return AuthUserReq(
            user = user
        )
    }

    fun toResponse(
        user: User
    ): AuthUserRes {
        return AuthUserRes(
            id = user.id!!,
            username = user.username,
            role = user.role,
            status = user.status,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }



}
