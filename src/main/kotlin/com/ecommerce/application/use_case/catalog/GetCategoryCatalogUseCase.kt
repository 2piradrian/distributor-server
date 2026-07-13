package com.ecommerce.application.use_case.catalog

import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetCategoryCatalogUseCase(
    private val categoryRepository: CategoryRepositoryI
) {

    data class Result(
        val categories: List<Category>
    )

    fun execute(): Result {
        val categories = categoryRepository.getAllPublicBasic()
        return Result(categories = categories)
    }
}
