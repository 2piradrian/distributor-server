package com.ecommerce.application.use_case.catalog

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetCategoryCatalogByIdUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val id: String
    )

    data class Result(
        val category: Category
    )

    fun execute(command: Command): Result {
        val category = categoryRepository.getPublicById(command.id)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        return Result(category = category)
    }
}
