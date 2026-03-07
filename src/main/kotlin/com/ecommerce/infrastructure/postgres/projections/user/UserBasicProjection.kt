package com.ecommerce.infrastructure.postgres.projections.user

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.Status

interface UserBasicProjection {
    fun getId(): String?
    fun getUsername(): String
    fun getRole(): Role
    fun getStatus(): Status
}
