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
    data class Command(val user: User)
    data class Result(val users: List<User>)

    fun execute(command: Command): Result {
        if (!command.user.isRole(setOf(Role.ADMIN))) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }
        return Result(userRepository.getAll())
    }
}
