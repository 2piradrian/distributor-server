package com.ecommerce.application.service

import com.ecommerce.application.use_case.product.*
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.mapper.*
import com.ecommerce.presentation.dto.product.request.*
import com.ecommerce.presentation.dto.product.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductService(
    /* ==== Dependencies === */
    private val userService: UserServiceI,

    /* ==== Use Cases === */
    private val create: CreateProductUseCase,
    private val update: UpdateProductUseCase,
    private val delete: DeleteProductUseCase,
    private val getById: GetProductByIdUseCase,
    private val getAll: GetAllProductsUseCase
) : ProductServiceI {

    override fun create(dto: CreateProductReq): CreateProductRes {
        val user: User = userService.auth(dto.token)

        val result = create.execute(
            command = CreateProductUseCase.Command(
                user = user,
                name = dto.name,
                description = dto.description,
                price = dto.price,
                stock = dto.stock,
                categoryId = dto.categoryId
            )
        )

        return CreateProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun update(dto: UpdateProductReq): UpdateProductRes {
        val user: User = userService.auth(dto.token)

        val result = update.execute(
            command = UpdateProductUseCase.Command(
                user = user,
                id = dto.id,
                name = dto.name,
                description = dto.description,
                price = dto.price,
                stock = dto.stock,
                categoryId = dto.categoryId
            )
        )

        return UpdateProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun delete(token: String, id: String) {
        val user: User = userService.auth(token)

        delete.execute(
            command = DeleteProductUseCase.Command(
                user = user,
                id = id
            )
        )
    }

    override fun getById(dto: GetProductByIdReq): GetProductByIdRes {
        val user: User = userService.auth(dto.token)

        val result = getById.execute(
            command = GetProductByIdUseCase.Command(
                user = user,
                id = dto.id
            )
        )

        return GetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getAll(dto: GetAllProductsReq): GetAllProductsRes {
        val user: User = userService.auth(dto.token)

        val result = getAll.execute(
            command = GetAllProductsUseCase.Command(
                user = user,
                filters = dto.filters
            )
        )

        return GetAllProductsMapper.toResponse(
            products = result.products
        )
    }
}
