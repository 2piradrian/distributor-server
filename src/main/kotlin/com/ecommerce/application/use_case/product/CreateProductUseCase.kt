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
import java.util.Date

@Component
@Transactional
class CreateProductUseCase(
    private val productRepository: ProductRepositoryI,
    private val categoryRepository: CategoryRepositoryI
) {

    data class Command(
        val user: User,
        val name: String,
        val description: String,
        val price: Double,
        val stock: Int,
        val categoryId: String
    )

    data class Result(
        val product: Product
    )

    fun execute(command: Command): Result {

        // 1. Validate the user role.
        if (!command.user.isRole(Role.ADMIN, Role.LOGISTICA)) {
            throw ErrorHandler(ErrorType.UNAUTHORIZED)
        }

        // 2. Check if a product with the same name already exists.
        val existingProduct = this.productRepository.getByName(command.name)
        if (existingProduct != null) {
            throw ErrorHandler(ErrorType.PRODUCT_ALREADY_EXISTS)
        }

        // 3. Validate category.
        val category = this.categoryRepository.getById(command.categoryId)
            ?: throw ErrorHandler(ErrorType.CATEGORY_NOT_FOUND)

        // 4. Create the new product.
        val newProduct = Product(
            id = null,
            name = command.name,
            description = command.description,
            price = command.price,
            stock = command.stock,
            category = category,
            createdAt = Date(),
            updatedAt = Date()
        )

        // 5. Save the product.
        val saved = this.productRepository.save(newProduct)

        // 6. End of Use Case.
        return Result(
            product = saved
        )
    }
}
