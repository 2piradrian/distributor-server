package com.distributor.presentation.dto.user.mapper

import com.distributor.domain.entity.User
import com.distributor.presentation.dto.user.request.GetUserByIdReq
import com.distributor.presentation.dto.user.response.GetUserByIdRes

object GetUserByIdMapper {

    fun toResponse(user: User): GetUserByIdRes {
        return GetUserByIdRes(
            id = user.id!!,
            username = user.username,
            role = user.role.toMap(),
            status = user.status.toMap()
        )
    }

    fun toRequest(token: String, id: String): GetUserByIdReq {
        return GetUserByIdReq.build(
            token = token,
            id = id
        )
    }

}