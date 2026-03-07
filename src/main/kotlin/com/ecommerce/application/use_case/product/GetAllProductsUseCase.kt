package com.ecommerce.application.use_case.product

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.User
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
        val user: User,
        val filters: ProductFilters? = null
    )

    data class Result(
        val products: List<Product>
    )

    fun execute(command: Command): Result {

        // 1. Fetch all products with filters.
        val products = productRepository.getAll(command.filters)

        // 2. End of Use Case.
        return Result(
            products = products
        )
    }
}
