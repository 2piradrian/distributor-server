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
class GetAllCategoriesUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?
    )

    data class Result(
        val categories: List<Category>
    )

    fun execute(command: Command): Result {
        // Validate user permissions for  access
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN, Role.LOGISTICA, Role.COMERCIAL)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val categories = categoryRepository.getAllBasic()
        return Result(categories = categories)
    }
}
