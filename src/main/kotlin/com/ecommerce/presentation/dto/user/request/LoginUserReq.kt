package com.ecommerce.presentation.dto.user.request

import jakarta.validation.constraints.NotBlank

data class LoginUserReq(

    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?,

)
