package com.ecommerce.application.use_case.catalog

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters
import com.ecommerce.domain.repository.ProductRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetProductCatalogUseCase(
    private val productRepository: ProductRepositoryI
) {

    data class Command(
        val filters: ProductFilters? = null
    )

    data class Result(
        val products: List<Product>
    )

    fun execute(command: Command): Result {
        val products = productRepository.getAllPublic(command.filters)
        return Result(products = products)
    }
}
