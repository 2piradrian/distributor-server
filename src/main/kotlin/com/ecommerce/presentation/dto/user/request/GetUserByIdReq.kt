package com.ecommerce.presentation.dto.user.request

import jakarta.validation.constraints.NotBlank

data class GetUserByIdReq(

    @field:NotBlank
    val token: String?,

    @field:NotBlank
    val id: String?,

)
