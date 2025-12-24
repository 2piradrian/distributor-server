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
class CreateUserUseCase(
    private val authHelper: AuthHelper,
    private val userRepository: UserRepositoryI
) {

    data class Command(
        val user: User,
        val username: String,
        val password: String,
        val role: Role
    )

    data class Result(val user: User)

    fun execute(command: Command): Result {
        // 1. Validate the user role.
        if (!command.user.isRole(setOf(Role.ADMIN))) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Check if the username already exists.
        val usernameCheck = userRepository.getByUsername(command.username)
        if (usernameCheck != null) {
            throw ErrorHandler(ErrorType.USERNAME_ALREADY_EXISTS)
        }

        // 3. Create the new user.
        val newUser = User(
            username = command.username,
            password = authHelper.hashPassword(command.password),
            role = command.role,
            status = Status.ACTIVE,
            createdAt = Date(),
            updatedAt = Date()
        )

        // 4. Save the user.
        val saved = userRepository.save(newUser)

        // 5. End of Use Case.
        return Result(saved)
    }
}
