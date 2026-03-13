package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.GetUserByIdReq
import com.ecommerce.presentation.dto.user.response.GetUserByIdRes

object GetUserByIdMapper {

    fun toRequest(
        token: String,
        id: String
    ): GetUserByIdReq {
        return GetUserByIdReq(
            token = token,
            id = id
        )
    }

    fun toResponse(
        user: User
    ): GetUserByIdRes {
        return GetUserByIdRes(
            id = user.id!!,
            username = user.username,
            role = user.role,
            status = user.status,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }

}
