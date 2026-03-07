package com.ecommerce.infrastructure.postgres.projections.user

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.Status
import java.util.Date

interface UserFullProjection {
    fun getId(): String?
    fun getUsername(): String
    fun getPassword(): String
    fun getRole(): Role
    fun getStatus(): Status
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
}
