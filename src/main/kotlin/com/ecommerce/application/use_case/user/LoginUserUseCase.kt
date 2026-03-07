package com.ecommerce.application.use_case.user

import com.ecommerce.core.helper.AuthHelper
import com.ecommerce.domain.entity.Status
import com.ecommerce.domain.entity.Token
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.UserRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class LoginUserUseCase(
    private val authHelper: AuthHelper,
    private val userRepository: UserRepositoryI
) {

    data class Command(
        val username: String,
        val password: String
    )

    data class Result(
        val token: Token
    )

    fun execute(command: Command): Result {

        // 1. Get the user by username.
        val user = this.userRepository.getByUsername(command.username)
            ?: throw ErrorHandler(ErrorType.USER_NOT_FOUND)

        // 2. Check if the user is active.
        if (user.status == Status.INACTIVE) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 3. Validate the password.
        if (!this.authHelper.validatePassword(user, command.password)) {
            throw ErrorHandler(ErrorType.INVALID_PASSWORD)
        }

        // 4. Create a token.
        val token = this.authHelper.createToken(user)

        // 5. End of Use Case.
        return Result(
            token = token
        )
    }
}
