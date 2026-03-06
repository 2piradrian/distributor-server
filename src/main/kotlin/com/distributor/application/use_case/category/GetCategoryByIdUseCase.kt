package com.distributor.application.use_case.category

import com.distributor.domain.entity.Category
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetCategoryByIdUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User,
        val id: String
    )

    data class Result(
        val category: Category
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.

        // 2. Fetch the category.
        val category = categoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 3. End of Use Case.
        return Result(
            category = category
        )
    }
}
