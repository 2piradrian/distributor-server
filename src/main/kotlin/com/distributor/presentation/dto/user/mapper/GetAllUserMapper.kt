package com.distributor.presentation.dto.user.mapper

import com.distributor.domain.entity.User
import com.distributor.presentation.dto.user.request.GetAllUserReq
import com.distributor.presentation.dto.user.response.GetAllUserRes

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