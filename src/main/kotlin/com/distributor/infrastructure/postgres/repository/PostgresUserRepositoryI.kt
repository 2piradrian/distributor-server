package com.distributor.infrastructure.postgres.repository

import com.distributor.infrastructure.postgres.model.UserModel
import com.distributor.infrastructure.postgres.projections.user.UserBasicProjection
import com.distributor.infrastructure.postgres.projections.user.UserFullProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostgresUserRepositoryI : JpaRepository<UserModel, String> {

    fun findFullById(id: String): Optional<UserFullProjection>

    fun findBasicById(id: String): Optional<UserBasicProjection>

    fun findFullByUsername(username: String): Optional<UserFullProjection>

    fun findBasicByUsername(username: String): Optional<UserBasicProjection>

    fun getByUsername(username: String): UserModel?

    fun <T> findAllBy(type: Class<T>): List<T>
}
