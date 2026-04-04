package com.ecommerce.presentation.dto.user.request

import jakarta.validation.constraints.NotBlank

data class CreateAdminUserReq(

    @field:NotBlank
    val secret: String?,

    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?

)
