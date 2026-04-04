package com.ecommerce.presentation.dto.user.request

import jakarta.validation.constraints.NotBlank

data class CreateUserReq(

    @field:NotBlank
    val token: String?,

    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?,

    @field:NotBlank
    val role: String?,

)
