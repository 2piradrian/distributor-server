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

    data class Result(
        val user: User
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        if (!command.user.isRole(Role.ADMIN)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Check if the username already exists.
        val usernameCheck = this.userRepository.getByUsername(command.username)
        if (usernameCheck != null) {
            throw ErrorHandler(ErrorType.USERNAME_ALREADY_EXISTS)
        }

        // 3. Create the new user.
        val newUser = User(
            id = null,
            username = command.username,
            password = this.authHelper.hashPassword(command.password),
            role = command.role,
            status = Status.ACTIVE,
            createdAt = Date(),
            updatedAt = Date()
        )

        // 4. Save the user.
        val saved = this.userRepository.save(newUser)

        // 5. End of Use Case.
        return Result(
            user = saved
        )
    }
}
