package com.distributor.application.use_case.user

import com.distributor.core.helper.AuthHelper
import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.domain.repository.UserRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.Date

@Component
@Transactional
class UpdateUserUseCase(
    private val authHelper: AuthHelper,
    private val userRepository: UserRepositoryI
) {
    data class Command(
        val user: User,
        val userId: String,
        val username: String,
        val password: String,
        val role: Role,
        val status: Status
    )
    data class Result(val user: User)

    fun execute(command: Command): Result {
        if (!command.user.isRole(setOf(Role.ADMIN))) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        val existingUser = userRepository.getById(command.userId)
            ?: throw ErrorHandler(ErrorType.USER_NOT_FOUND)

        val usernameCheck = userRepository.getByUsername(command.username)
        if (usernameCheck != null && usernameCheck.id != command.userId) {
            throw ErrorHandler(ErrorType.USERNAME_ALREADY_EXISTS)
        }

        val updatedUser = existingUser.copy(
            username = command.username,
            password = authHelper.hashPassword(command.password),
            role = command.role,
            status = command.status,
            updatedAt = Date()
        )

        return Result(userRepository.update(updatedUser))
    }
}
