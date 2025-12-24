package com.distributor.datasource.repository

import com.distributor.datasource.postgres.mapper.UserEntityMapper
import com.distributor.datasource.postgres.repository.PostgresUserRepositoryI
import com.distributor.domain.entity.User
import com.distributor.domain.repository.UserRepositoryI
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val userRepository: PostgresUserRepositoryI
) : UserRepositoryI {

    override fun getById(userId: String): User? {
        val userModel = userRepository.findById(userId).orElse(null)
        return UserEntityMapper.toDomain(userModel)
    }

    override fun getByUsername(username: String): User? {
        val userModel = userRepository.getByUsername(username)
        return UserEntityMapper.toDomain(userModel)
    }

    override fun getAll(): List<User> {
        return UserEntityMapper.toDomain(userRepository.findAll())
    }

    override fun save(user: User): User {
        val userModel = UserEntityMapper.toModel(user)!!
        val saved = userRepository.save(userModel)
        return UserEntityMapper.toDomain(saved)!!
    }

    override fun update(user: User): User {
        return save(user)
    }
}
