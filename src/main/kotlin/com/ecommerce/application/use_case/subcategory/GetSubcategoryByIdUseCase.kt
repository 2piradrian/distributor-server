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
class GetSubcategoryByIdUseCase(
    private val subcategoryRepository: SubcategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String
    )

    data class Result(
        val subcategory: Subcategory
    )

    fun execute(command: Command): Result {
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val subcategory = this.subcategoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.SUBCATEGORY_NOT_FOUND)

        return Result(subcategory = subcategory)
    }
}
