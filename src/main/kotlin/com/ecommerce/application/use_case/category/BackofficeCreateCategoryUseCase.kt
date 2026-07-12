package com.ecommerce.application.use_case.category

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.Date

@Component
@Transactional
class BackofficeCreateCategoryUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?,
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

        // 2. Check if a category with the same name already exists.
        val existingCategory = this.categoryRepository.getByName(command.name)
        if (existingCategory != null) {
            throw ErrorHandler(ErrorType.CATEGORY_ALREADY_EXISTS)
        }

        // 3. Create the new category.
        val newCategory = Category(
            id = null,
            name = command.name,
            slug = command.slug,
            createdAt = Date(),
            updatedAt = Date()
        )

        // 4. Save the category.
        val saved = this.categoryRepository.save(newCategory)

        // 5. End of Use Case.
        return Result(
            category = saved
        )
    }
}
