package com.ecommerce.application.use_case.product

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.filters.ProductFilters
import com.ecommerce.domain.repository.ProductRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetAllProductsUseCase(
    private val productRepository: ProductRepositoryI
) {

    data class Command(
        val user: User?,
        val filters: ProductFilters? = null
    )

    data class Result(
        val products: List<Product>
    )

    fun execute(command: Command): Result {
        // Validate user permissions for  access
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN, Role.LOGISTICA, Role.COMERCIAL)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val products = productRepository.getAll(command.filters)
        return Result(products = products)
    }
}
