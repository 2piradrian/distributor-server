package com.distributor.application.use_case.category

import com.distributor.domain.entity.Category
import com.distributor.domain.entity.Role
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.Date

@Component
@Transactional
class CreateCategoryUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User,
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

        // 2. Check if a category with the same name already exists.
        val existingCategory = categoryRepository.getByName(command.name)
        if (existingCategory != null) {
            throw ErrorHandler(ErrorType.CATEGORY_ALREADY_EXISTS)
        }

        // 3. Create the new category.
        val newCategory = Category(
            id = null,
            name = command.name,
            createdAt = Date(),
            updatedAt = Date()
        )

        // 4. Save the category.
        val saved = categoryRepository.save(newCategory)

        // 5. End of Use Case.
        return Result(
            category = saved
        )
    }
}
