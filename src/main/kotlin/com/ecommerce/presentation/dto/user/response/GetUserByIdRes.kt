package com.ecommerce.presentation.dto.user.response

data class GetUserByIdRes(
    val id: String,
    val username: String,
    val role: Map<String, String>,
    val status: Map<String, String>
)
