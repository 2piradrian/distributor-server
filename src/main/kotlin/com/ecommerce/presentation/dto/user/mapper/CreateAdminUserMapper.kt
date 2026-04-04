package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.CreateAdminUserReq
import com.ecommerce.presentation.dto.user.response.CreateAdminUserRes

object CreateAdminUserMapper {

    fun toRequest(
        payload: Map<String, Any>
    ): CreateAdminUserReq {
        return CreateAdminUserReq(
            secret = payload["secret"] as? String,
            username = payload["username"] as? String,
            password = payload["password"] as? String
        )
    }

    fun toResponse(
        user: User
    ): CreateAdminUserRes {
        return CreateAdminUserRes(
            id = user.id!!,
            username = user.username,
            role = user.role,
            status = user.status,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }

}
