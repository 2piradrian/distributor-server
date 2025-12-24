package com.distributor.presentation.dto.user.response

import com.distributor.domain.entity.Role

data class AuthUserRes(
    val id: String?,
    val username: String?,
    val role: Role?
)
