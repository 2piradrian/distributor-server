package com.distributor.domain.repository

import com.distributor.domain.entity.User

interface UserRepositoryI {
    fun getById(userId: String): User?
    fun getByUsername(username: String): User?
    fun getAll(): List<User>
    fun save(user: User): User
    fun update(user: User): User
}
