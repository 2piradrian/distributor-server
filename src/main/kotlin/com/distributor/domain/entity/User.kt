package com.distributor.domain.entity

import java.util.Date

class User(
    val id: String? = null,
    val username: String? = null,
    val password: String? = null,
    val role: Role? = null,
    val status: Status? = null,
    val createdAt: Date? = null,
    val updatedAt: Date? = null
) {
    fun isRole(roles: Set<Role>): Boolean {
        return roles.contains(this.role)
    }
}
