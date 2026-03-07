package com.ecommerce.application.use_case.user

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.UserRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetAllUsersUseCase(
    private val userRepository: UserRepositoryI
) {

    data class Command(
        val user: User
    )

    data class Result(
        val users: List<User>
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        if (!command.user.isRole(Role.ADMIN)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Get all users.
        val users = this.userRepository.getAll()

        // 3. End of Use Case.
        return Result(
            users = users
        )
    }
}