package com.ecommerce.application.use_case.user

import com.ecommerce.core.helper.AuthHelper
import com.ecommerce.domain.entity.Status
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.UserRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class AuthenticateUserUseCase(
    private val authHelper: AuthHelper,
    private val userRepository: UserRepositoryI
) {

    data class Command(
        val token: String
    )

    data class Result(
        val user: User
    )

    fun execute(command: Command): Result {

        // 1. Validate the token.
        val sessionToken = this.authHelper.validateToken(command.token)
            ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Get the user from the token subject.
        val subject = authHelper.getSubject(sessionToken)
        val user = userRepository.getById(subject)
            ?: throw ErrorHandler(ErrorType.USER_NOT_FOUND)

        // 3. Check if the user is active.
        if (user.status == Status.INACTIVE) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 4. End of Use Case.
        return Result(
            user = user
        )
    }
}
