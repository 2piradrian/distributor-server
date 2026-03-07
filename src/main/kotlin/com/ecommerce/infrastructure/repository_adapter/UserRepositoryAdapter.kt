package com.ecommerce.infrastructure.repository_adapter

import com.ecommerce.infrastructure.postgres.mapper.UserEntityMapper
import com.ecommerce.infrastructure.postgres.projections.user.UserBasicProjection
import com.ecommerce.infrastructure.postgres.projections.user.UserFullProjection
import com.ecommerce.infrastructure.postgres.repository.PostgresUserRepositoryI
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.repository.UserRepositoryI
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryAdapter(
    private val userRepository: PostgresUserRepositoryI
) : UserRepositoryI {

    override fun getById(userId: String): User? {
        val model = userRepository.findFullById(userId).orElse(null)
        return UserEntityMapper.toDomain(model)
    }

    override fun getBasicById(userId: String): User? {
        val model = userRepository.findBasicById(userId).orElse(null)
        return UserEntityMapper.toDomain(model)
    }

    override fun getByUsername(username: String): User? {
        val model = userRepository.findFullByUsername(username).orElse(null)
        return UserEntityMapper.toDomain(model)
    }

    override fun getBasicByUsername(username: String): User? {
        val model = userRepository.findBasicByUsername(username).orElse(null)
        return UserEntityMapper.toDomain(model)
    }

    override fun getAll(): List<User> {
        val models = userRepository.findAllBy(UserFullProjection::class.java)
        return UserEntityMapper.toDomain(models, UserEntityMapper::toDomain)
    }

    override fun getAllBasic(): List<User> {
        val models = userRepository.findAllBy(UserBasicProjection::class.java)
        return UserEntityMapper.toDomain(models, UserEntityMapper::toDomain)
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
