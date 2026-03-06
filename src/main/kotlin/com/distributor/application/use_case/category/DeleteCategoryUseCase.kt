package com.distributor.application.use_case.category

import com.distributor.domain.entity.Role
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class DeleteCategoryUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User,
        val id: String
    )

    fun execute(command: Command) {

        // 1. Validate the user role.
        if (!command.user.isRole(Role.ADMIN)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Fetch the category.
        val category = categoryRepository.getBasicById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 3. Delete the category.
        categoryRepository.delete(command.id)
    }
}
