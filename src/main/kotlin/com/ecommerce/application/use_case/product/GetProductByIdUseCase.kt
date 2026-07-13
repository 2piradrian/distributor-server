package com.ecommerce.application.use_case.product

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.ProductRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetProductByIdUseCase(
    private val productRepository: ProductRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String
    )

    data class Result(
        val product: Product
    )

    fun execute(command: Command): Result {
        // Validate user permissions for  access
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN, Role.LOGISTICA, Role.COMERCIAL)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val product = productRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.PRODUCT_NOT_FOUND)

        return Result(product = product)
    }
}
