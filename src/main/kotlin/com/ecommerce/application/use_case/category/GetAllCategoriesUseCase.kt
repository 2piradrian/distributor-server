package com.ecommerce.application.use_case.category

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.entity.User
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

        // 1. Fetch all categories.
        val categories = if (command.user != null) {
            this.categoryRepository.getAllBasic()
        }
        else {
            this.categoryRepository.getAllPublicBasic()
        }

        // 2. End of Use Case.
        return Result(
            categories = categories
        )
    }
}
