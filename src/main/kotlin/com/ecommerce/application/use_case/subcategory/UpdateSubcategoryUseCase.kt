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

@Component
@Transactional
class UpdateSubcategoryUseCase(
    private val subcategoryRepository: SubcategoryRepositoryI,
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String,
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

        // 2. Fetch the subcategory
        val subcategory = this.subcategoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.SUBCATEGORY_NOT_FOUND)

        // 3. Check if name is already taken
        val existingSub = this.subcategoryRepository.getByName(command.name)
        if (existingSub != null && existingSub.id != command.id) {
            throw ErrorHandler(ErrorType.SUBCATEGORY_ALREADY_EXISTS)
        }

        // 4. Validate new parent category exists
        val newCategory = this.categoryRepository.getById(command.categoryId)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 5. Update and save subcategory
        subcategory.update(command.name, command.slug)
        val savedSubcategory = this.subcategoryRepository.save(subcategory)

        // 6. Handle parent category association update
        val categories = this.categoryRepository.getAll()
        val oldCategory = categories.find { cat -> cat.subcategories.any { it.id == command.id } }

        if (oldCategory != null && oldCategory.id != newCategory.id) {
            // Remove from old category list and save
            oldCategory.subcategories = oldCategory.subcategories.filter { it.id != command.id }
            this.categoryRepository.save(oldCategory)
            
            // Add to new category list and save
            newCategory.subcategories += savedSubcategory
            this.categoryRepository.save(newCategory)
        }
        else if (oldCategory == null) {
            // If it had no parent, add to the new category and save
            newCategory.subcategories += savedSubcategory
            this.categoryRepository.save(newCategory)
        }

        return Result(subcategory = savedSubcategory)
    }
}
