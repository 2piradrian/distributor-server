package com.distributor.presentation.dto.user.response

import com.distributor.domain.entity.User

data class GetAllUserRes(
    val users: List<User>
)
