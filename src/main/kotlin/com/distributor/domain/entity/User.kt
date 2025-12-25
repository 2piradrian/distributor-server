package com.distributor.domain.entity

import java.util.Date

class User(
    val id: String?,
    var username: String,
    var password: String,
    var role: Role,
    var status: Status,
    val createdAt: Date,
    var updatedAt: Date
) {

    fun isRole(vararg roles: Role): Boolean {
        return roles.contains(role)
    }

    fun isActive(): Boolean {
        return status == Status.ACTIVE
    }

    fun update(
        username: String,
        hashedPassword: String,
        role: Role,
        status: Status
    ) {
        this.username = username
        this.password = hashedPassword
        this.role = role
        this.status = status
        this.updatedAt = Date()
    }
}

