package com.ecommerce.application.use_case.category

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetCategoryByIdUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String
    )

    data class Result(
        val category: Category
    )

    fun execute(command: Command): Result {
        // Validate user permissions for  access
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN, Role.LOGISTICA, Role.COMERCIAL)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val category = categoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        return Result(category = category)
    }
}
