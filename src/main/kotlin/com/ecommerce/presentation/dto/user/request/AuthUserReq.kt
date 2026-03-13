package com.ecommerce.presentation.dto.user.request

import jakarta.validation.constraints.NotBlank

data class AuthUserReq(

    @field:NotBlank
    val token: String

)
