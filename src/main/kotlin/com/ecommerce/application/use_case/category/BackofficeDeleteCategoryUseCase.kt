package com.ecommerce.application.use_case.category

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class BackofficeDeleteCategoryUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String
    )

    fun execute(command: Command) {

        // 1. Validate the user role.
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Fetch the category.
        val category = this.categoryRepository.getBasicById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 3. Delete the category.
        this.categoryRepository.delete(category.id!!)
    }
}
