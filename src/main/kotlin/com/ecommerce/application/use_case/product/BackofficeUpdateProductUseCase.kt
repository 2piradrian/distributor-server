package com.ecommerce.application.use_case.product

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.domain.repository.CategoryRepositoryI
import com.ecommerce.domain.repository.ProductRepositoryI
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class BackofficeUpdateProductUseCase(
    private val productRepository: ProductRepositoryI,
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User?,
        val id: String,
        val name: String,
        val description: String,
        val price: Double,
        val offerPrice: Double?,
        val stock: Int,
        val categoryId: String,
        val mainImage: String?,
        val images: List<String>,
        val isVisible: Boolean
    )

    data class Result(
        val product: Product
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        command.user?.takeIf {
            it.validatePermissions(Role.ADMIN)
        } ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        // 2. Check if the product exists.
        val product = productRepository.getById(command.id)
            ?: throw ErrorHandler(ErrorType.PRODUCT_NOT_FOUND)

        // 3. Check if a product with the same name already exists (if name changed).
        if (product.name != command.name) {
            val existingProduct = productRepository.getByName(command.name)
            if (existingProduct != null) {
                throw ErrorHandler(ErrorType.PRODUCT_ALREADY_EXISTS)
            }
        }

        // 4. Validate category.
        val category = categoryRepository.getById(command.categoryId)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 5. Update the product.
        product.update(
            name = command.name,
            description = command.description,
            price = command.price,
            offerPrice = command.offerPrice,
            stock = command.stock,
            category = category,
            mainImage = command.mainImage,
            images = command.images,
            isVisible = command.isVisible
        )

        // 6. Save the product.
        val updated = this.productRepository.update(product)

        // 7. End of Use Case.
        return Result(
            product = updated
        )
    }
}
