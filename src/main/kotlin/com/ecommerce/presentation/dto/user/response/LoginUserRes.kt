package com.ecommerce.presentation.dto.user.response

import com.ecommerce.domain.entity.Token

data class LoginUserRes(
    val token: Token
)
