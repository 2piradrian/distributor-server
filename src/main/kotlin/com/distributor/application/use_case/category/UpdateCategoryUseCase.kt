package com.distributor.application.use_case.category

import com.distributor.domain.entity.Category
import com.distributor.domain.entity.Role
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class UpdateCategoryUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User,
        val id: String,
        val name: String
    )

    data class Result(
        val category: Category
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        if (!command.user.isRole(Role.ADMIN, Role.LOGISTICA)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Fetch the category.
        val category = categoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 3. Check if another category with the same name already exists.
        val existingCategory = categoryRepository.getByName(command.name)
        if (existingCategory != null && existingCategory.id != command.id) {
            throw ErrorHandler(ErrorType.CATEGORY_ALREADY_EXISTS)
        }

        // 4. Update the category.
        category.update(command.name)

        // 5. Save the category.
        val saved = categoryRepository.save(category)

        // 6. End of Use Case.
        return Result(
            category = saved
        )
    }
}
