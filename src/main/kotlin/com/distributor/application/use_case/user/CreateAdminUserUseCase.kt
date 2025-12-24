package com.distributor.application.use_case.user

import com.distributor.core.helper.AuthHelper
import com.distributor.core.helper.SecretKeyHelper
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
class CreateAdminUserUseCase(
    private val authHelper: AuthHelper,
    private val secretKeyHelper: SecretKeyHelper,
    private val userRepository: UserRepositoryI
) {
    data class Command(val secret: String, val username: String, val password: String)
    data class Result(val user: User)

    fun execute(command: Command): Result {
        if (!secretKeyHelper.isValid(command.secret)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }
        
        val usernameCheck = userRepository.getByUsername(command.username)
        if (usernameCheck != null) {
            throw ErrorHandler(ErrorType.USERNAME_ALREADY_EXISTS)
        }

        val newUser = User(
            username = command.username,
            password = authHelper.hashPassword(command.password),
            role = Role.ADMIN,
            status = Status.ACTIVE,
            createdAt = Date(),
            updatedAt = Date()
        )

        val saved = userRepository.save(newUser)
        return Result(saved)
    }
}
