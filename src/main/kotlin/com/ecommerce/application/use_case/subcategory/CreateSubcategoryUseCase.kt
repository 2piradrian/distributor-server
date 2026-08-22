package com.ecommerce.application.use_case.subcategory

import com.ecommerce.domain.entity.Subcategory
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.CategoryRepositoryI
import com.ecommerce.domain.repository.SubcategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.Date

@Component
@Transactional
class CreateSubcategoryUseCase(
    private val categoryRepository: CategoryRepositoryI,
    private val subcategoryRepository: SubcategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val name: String,
        val slug: String,
        val categoryId: String
    )

    data class Result(
        val subcategory: Subcategory
    )

    fun execute(command: Command): Result {
        // 1. Validate permissions
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Validate category exists
        val category = this.categoryRepository.getById(command.categoryId)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 3. Validate unique name
        val existingSub = this.subcategoryRepository.getByName(command.name)
        if (existingSub != null) {
            throw ErrorHandler(ErrorType.SUBCATEGORY_ALREADY_EXISTS)
        }

        // 4. Create new subcategory
        val newSubcategory = Subcategory(
            id = null,
            name = command.name,
            slug = command.slug,
            createdAt = Date(),
            updatedAt = Date()
        )

        // 5. Add to category list and save category
        category.subcategories += newSubcategory
        val savedCategory = this.categoryRepository.save(category)

        // 6. Find the saved subcategory in the list (it will have id generated)
        val savedSubcategory = savedCategory.subcategories.find { it.slug == command.slug }
            ?: throw ErrorHandler(ErrorType.INTERNAL_ERROR)

        return Result(subcategory = savedSubcategory)
    }
}
