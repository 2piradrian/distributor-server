package com.distributor.datasource.postgres.mapper

import com.distributor.datasource.postgres.model.UserModel
import com.distributor.domain.entity.User

object UserEntityMapper {

    fun toDomain(model: UserModel?): User? {
        return model?.let {
            User(
                id = it.id,
                username = it.username,
                password = it.password,
                role = it.role,
                status = it.status,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }


    fun toModel(domain: User?): UserModel? {
        return domain?.let {
            UserModel().apply {
                id = it.id
                username = it.username
                password = it.password
                role = it.role
                status = it.status
                createdAt = it.createdAt
                updatedAt = it.updatedAt
            }
        }
    }

    fun toDomain(models: List<UserModel>): List<User> =
        models.mapNotNull { toDomain(it) }

    fun toModel(domains: List<User>): List<UserModel> =
        domains.mapNotNull { toModel(it) }

}
