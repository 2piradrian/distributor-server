package com.distributor.presentation.dto.user.response

import com.distributor.domain.entity.Token

data class LoginUserRes(
    val token: Token?
)
