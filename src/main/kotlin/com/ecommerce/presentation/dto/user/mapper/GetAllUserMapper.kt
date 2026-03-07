package com.ecommerce.presentation.dto.user.mapper

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.GetAllUserReq
import com.ecommerce.presentation.dto.user.response.GetAllUserRes

object GetAllUserMapper {

    fun toResponse(users: List<User>): GetAllUserRes {
        return GetAllUserRes(
            users = users
        )
    }

    fun toRequest(token: String): GetAllUserReq {
        return GetAllUserReq.build(
            token =  token
        )
    }

}