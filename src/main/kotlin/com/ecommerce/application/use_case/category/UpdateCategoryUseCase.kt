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
class UpdateCategoryUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String,
        val name: String,
        val slug: String
    )

    data class Result(
        val category: Category
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Fetch the category.
        val category = this.categoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 3. Check if another category with the same name already exists.
        val existingCategory = this.categoryRepository.getByName(command.name)
        if (existingCategory != null && existingCategory.id != command.id) {
            throw ErrorHandler(ErrorType.CATEGORY_ALREADY_EXISTS)
        }

        // 4. Update the category.
        category.update(command.name, command.slug)

        // 5. Save the category.
        val saved = this.categoryRepository.save(category)

        // 6. End of Use Case.
        return Result(
            category = saved
        )
    }
}
