package com.ecommerce.application.use_case.subcategory

import com.ecommerce.domain.entity.Subcategory
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.SubcategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetAllSubcategoriesUseCase(
    private val subcategoryRepository: SubcategoryRepositoryI
) {

    data class Command(
        val user: User?
    )

    data class Result(
        val subcategories: List<Subcategory>
    )

    fun execute(command: Command): Result {
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val subcategories = this.subcategoryRepository.getAll()

        return Result(subcategories = subcategories)
    }
}
