package com.ecommerce.application.use_case.product

import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.ProductRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class DeleteProductUseCase(
    private val productRepository: ProductRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String
    )

    fun execute(command: Command) {

        // 1. Validate the user role.
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Check if the product exists.
        val product = this.productRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.PRODUCT_NOT_FOUND)

        // 3. Delete the product.
        this.productRepository.delete(product.id!!)

        // 4. End of Use Case.
    }
}
