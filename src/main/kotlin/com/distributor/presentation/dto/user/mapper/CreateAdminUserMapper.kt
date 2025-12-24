package com.distributor.presentation.dto.user.mapper

import com.distributor.domain.entity.User
import com.distributor.presentation.dto.user.request.CreateAdminUserReq
import com.distributor.presentation.dto.user.response.CreateAdminUserRes

object CreateAdminUserMapper {
    fun toResponse(user: User): CreateAdminUserRes {
        return CreateAdminUserRes(user.id, user.username, user.role?.name, user.status?.name)
    }

    fun toRequest(payload: Map<String, Any>): CreateAdminUserReq {
        return CreateAdminUserReq.build(
            payload["secret"] as? String,
            payload["username"] as? String,
            payload["password"] as? String
        )
    }
}