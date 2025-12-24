package com.distributor.datasource.postgres.repository

import com.distributor.datasource.postgres.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresUserRepositoryI : JpaRepository<UserModel, String> {
    fun getByUsername(username: String): UserModel?
}
