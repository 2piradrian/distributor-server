package com.ecommerce.presentation.dto.user.response

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.Status
import java.util.Date

data class GetUserByIdRes(
    val id: String,
    val username: String,
    val role: Role,
    val status: Status,
    val createdAt: Date?,
    val updatedAt: Date?
)
