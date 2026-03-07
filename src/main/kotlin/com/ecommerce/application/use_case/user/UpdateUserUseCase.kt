package com.ecommerce.application.use_case.user

import com.ecommerce.core.helper.AuthHelper
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.Status
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.UserRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

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

    data class Result(
        val user: User
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        if (!command.user.isRole(Role.ADMIN)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Get the existing user.
        val existingUser = this.userRepository.getById(command.userId)
            ?: throw ErrorHandler(ErrorType.USER_NOT_FOUND)

        // 3. Check if the username already exists.
        val usernameCheck = this.userRepository.getByUsername(command.username)
        if (usernameCheck != null && usernameCheck.id != command.userId) {
            throw ErrorHandler(ErrorType.USERNAME_ALREADY_EXISTS)
        }

        // 4. Update the user.
        existingUser.update(
            username = command.username,
            hashedPassword = authHelper.hashPassword(command.password),
            role = command.role,
            status = command.status,
        )

        // 5. Save the user.
        val saved = this.userRepository.update(existingUser)

        // 6. End of Use Case.
        return Result(
            user = saved
        )
    }
}