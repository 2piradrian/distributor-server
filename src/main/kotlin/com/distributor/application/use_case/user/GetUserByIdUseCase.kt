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
class GetUserByIdUseCase(
    private val userRepository: UserRepositoryI
) {

    data class Command(
        val user: User,
        val userId: String
    )

    data class Result(
        val user: User
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role or identity.
        if (!command.user.isRole(Role.ADMIN)) {
             if (command.user.id != command.userId) {
                 throw ErrorHandler(ErrorType.UNAUTHORIZED)
             }
        }

        // 2. Get the user by id.
        val user = userRepository.getById(command.userId)
            ?: throw ErrorHandler(ErrorType.USER_NOT_FOUND)

        // 3. End of Use Case.
        return Result(
            user = user
        )
    }
}