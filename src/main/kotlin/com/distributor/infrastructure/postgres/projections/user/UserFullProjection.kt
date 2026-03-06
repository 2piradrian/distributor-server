package com.distributor.infrastructure.postgres.projections.user

import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status
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
