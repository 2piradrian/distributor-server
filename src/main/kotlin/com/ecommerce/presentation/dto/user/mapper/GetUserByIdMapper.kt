package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.GetUserByIdReq
import com.ecommerce.presentation.dto.user.response.GetUserByIdRes

object GetUserByIdMapper {

    fun toRequest(
        user: User?,
        id: String
    ): GetUserByIdReq {
        return GetUserByIdReq(
            user = user,
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
