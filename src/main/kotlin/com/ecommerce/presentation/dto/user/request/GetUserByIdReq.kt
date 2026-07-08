package com.ecommerce.presentation.dto.user.request

import com.ecommerce.domain.entity.User
import jakarta.validation.constraints.NotBlank

data class GetUserByIdReq(

    val user: User?,

    @field:NotBlank
    val id: String?,

)
