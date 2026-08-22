package com.ecommerce.application.use_case.subcategory

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.SubcategoryRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class DeleteSubcategoryUseCase(
    private val subcategoryRepository: SubcategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String
    )

    fun execute(command: Command) {
        // 1. Validate permissions
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Verify existence
        this.subcategoryRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.SUBCATEGORY_NOT_FOUND)

        // 3. Delete
        this.subcategoryRepository.delete(command.id)
    }
}
