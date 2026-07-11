package com.ecommerce.application.use_case.product

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.ProductRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class GetShopProductByIdUseCase(
    private val productRepository: ProductRepositoryI
) {

    data class Command(
        val id: String
    )

    data class Result(
        val product: Product
    )

    fun execute(command: Command): Result {
        val product = productRepository.getPublicById(command.id)
            ?: throw ErrorHandler(ErrorType.PRODUCT_NOT_FOUND)

        if (!product.isVisible) {
            throw ErrorHandler(ErrorType.PRODUCT_NOT_FOUND)
        }

        return Result(product = product)
    }
}
