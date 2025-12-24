package com.distributor.application.use_case.user

import com.distributor.domain.entity.Role
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.domain.repository.UserRepositoryI
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
        val users = userRepository.getAll()

        // 3. End of Use Case.
        return Result(
            users = users
        )
    }
}