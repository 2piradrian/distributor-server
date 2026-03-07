package com.ecommerce.presentation.dto.user.response

import com.ecommerce.domain.entity.Role

data class AuthUserRes(
    val id: String,
    val username: String,
    val role: Role
)
