package com.ecommerce.presentation.dto.user.response

import com.ecommerce.domain.entity.User

data class GetAllUserRes(
    val users: List<User>
)
