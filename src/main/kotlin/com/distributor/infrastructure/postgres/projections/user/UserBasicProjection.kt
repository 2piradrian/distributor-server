package com.distributor.infrastructure.postgres.projections.user

import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status

interface UserBasicProjection {
    fun getId(): String?
    fun getUsername(): String
    fun getRole(): Role
    fun getStatus(): Status
}
