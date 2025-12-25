package com.distributor.presentation.dto.user.response

data class CreateAdminUserRes(
    val id: String,
    val username: String,
    val role: Map<String, String>,
    val status: Map<String, String>
)
