package com.distributor.datasource.postgres.mapper

import com.distributor.datasource.postgres.model.UserModel
import com.distributor.domain.entity.User

object UserEntityMapper {

    fun toDomain(model: UserModel?): User? {
        if (model == null) return null
        return User(
            id = model.id,
            username = model.username,
            password = model.password,
            role = model.role,
            status = model.status,
            createdAt = model.createdAt,
            updatedAt = model.updatedAt
        )
    }

    fun toModel(domain: User?): UserModel? {
        if (domain == null) return null
        return UserModel(
            id = domain.id,
            username = domain.username,
            password = domain.password,
            role = domain.role,
            status = domain.status,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }

    fun toDomain(models: List<UserModel>?): List<User> {
        if (models == null) return emptyList()
        return models.mapNotNull { toDomain(it) }
    }

    fun toModel(domains: List<User>?): List<UserModel> {
        if (domains == null) return emptyList()
        return domains.mapNotNull { toModel(it) }
    }
}
