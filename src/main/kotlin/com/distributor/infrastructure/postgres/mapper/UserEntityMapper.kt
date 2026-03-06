package com.distributor.infrastructure.postgres.mapper

import com.distributor.infrastructure.postgres.model.UserModel
import com.distributor.infrastructure.postgres.projections.user.UserBasicProjection
import com.distributor.infrastructure.postgres.projections.user.UserFullProjection
import com.distributor.domain.entity.User

object UserEntityMapper {

    // --- --- --- --- --- --- From Model --- --- --- --- --- --- //

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

    // --- --- --- --- --- --- From Projections --- --- --- --- --- --- //

    fun toDomain(projection: UserFullProjection?): User? {
        return projection?.let {
            User(
                id = it.getId(),
                username = it.getUsername(),
                password = it.getPassword(),
                role = it.getRole(),
                status = it.getStatus(),
                createdAt = it.getCreatedAt(),
                updatedAt = it.getUpdatedAt()
            )
        }
    }

    fun toDomain(projection: UserBasicProjection?): User? {
        return projection?.let {
            User(
                id = it.getId(),
                username = it.getUsername(),
                password = null,
                role = it.getRole(),
                status = it.getStatus(),
                createdAt = null,
                updatedAt = null
            )
        }
    }

    // --- --- --- --- --- --- To Model --- --- --- --- --- --- //

    fun toModel(domain: User?): UserModel? {
        return domain?.let {
            UserModel().apply {
                id = it.id
                username = it.username
                password = it.password!!
                role = it.role
                status = it.status
                createdAt = it.createdAt!!
                updatedAt = it.updatedAt!!
            }
        }
    }

    // --- --- --- --- --- --- From Lists --- --- --- --- --- --- //

    fun <T> toDomain(source: List<T>?, mapper: (T) -> User?): List<User> {
        return source?.mapNotNull { mapper(it) } ?: emptyList()
    }

    fun toDomain(models: List<UserModel>?): List<User> =
        models?.mapNotNull { toDomain(it) } ?: emptyList()

    fun toModel(domains: List<User>?): List<UserModel> =
        domains?.mapNotNull { toModel(it) } ?: emptyList()

}
