package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank

data class UpdateUserReq(

    val user: User?,

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?,

    @field:NotBlank
    val role: String?,

    @field:NotBlank
    val status: String?,

)
