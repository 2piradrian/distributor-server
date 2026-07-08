package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.GetAllUserReq
import com.ecommerce.presentation.dto.user.response.GetAllUserRes

object GetAllUserMapper {

    fun toRequest(
        user: User?
    ): GetAllUserReq {
        return GetAllUserReq(
            user = user
        )
    }

    fun toResponse(
        users: List<User>
    ): GetAllUserRes {
        return GetAllUserRes(
            users = users
        )
    }

}
