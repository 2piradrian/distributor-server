package com.ecommerce.application.service

import com.ecommerce.application.use_case.product.*
import com.ecommerce.presentation.dto.product.mapper.*
import com.ecommerce.presentation.dto.product.request.*
import com.ecommerce.presentation.dto.product.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductService(
    private val create: CreateProductUseCase,
    private val update: UpdateProductUseCase,
    private val delete: DeleteProductUseCase,
    private val getById: GetProductByIdUseCase,
    private val getAll: GetAllProductsUseCase
) : ProductServiceI {

    override fun createProduct(dto: CreateProductReq): CreateProductRes {
        val result = create.execute(
            command = CreateProductUseCase.Command(
                user = dto.user,
                name = dto.name!!,
                description = dto.description!!,
                price = dto.price!!,
                offerPrice = dto.offerPrice,
                stock = dto.stock!!,
                categoryId = dto.categoryId!!,
                mainImage = dto.mainImage,
                images = dto.images,
                isVisible = dto.isVisible!!
            )
        )

        return CreateProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun updateProduct(dto: UpdateProductReq): UpdateProductRes {
        val result = update.execute(
            command = UpdateProductUseCase.Command(
                user = dto.user,
                id = dto.id!!,
                name = dto.name!!,
                description = dto.description!!,
                price = dto.price!!,
                offerPrice = dto.offerPrice,
                stock = dto.stock!!,
                categoryId = dto.categoryId!!,
                mainImage = dto.mainImage,
                images = dto.images,
                isVisible = dto.isVisible!!
            )
        )

        return UpdateProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun deleteProduct(dto: DeleteProductReq) {
        this.delete.execute(
            command = DeleteProductUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getProductById(dto: GetProductByIdReq): GetProductByIdRes {
        val result = this.getById.execute(
            command = GetProductByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return GetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getAllProducts(dto: GetAllProductsReq): GetAllProductsRes {
        val result = this.getAll.execute(
            command = GetAllProductsUseCase.Command(
                user = dto.user,
                filters = dto.filters
            )
        )

        return GetAllProductsMapper.toResponse(
            products = result.products
        )
    }
}
