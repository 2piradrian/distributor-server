package com.ecommerce.application.service

import com.ecommerce.application.use_case.product.*
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.presentation.dto.product.mapper.*
import com.ecommerce.presentation.dto.product.request.*
import com.ecommerce.presentation.dto.product.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductService(

    /* ==== Use Cases === */
    private val create: CreateProductUseCase,
    private val update: UpdateProductUseCase,
    private val delete: DeleteProductUseCase,
    private val getShopById: GetShopProductByIdUseCase,
    private val getShopCatalog: GetShopProductsCatalogUseCase,
    private val getBackofficeById: GetBackofficeProductByIdUseCase,
    private val getBackofficeCatalog: GetBackofficeProductsCatalogUseCase

) : ProductServiceI {

    override fun create(dto: CreateProductReq): CreateProductRes {
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

    override fun update(dto: UpdateProductReq): UpdateProductRes {
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

    override fun delete(dto: DeleteProductReq) {
        this.delete.execute(
            command = DeleteProductUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getShopById(dto: GetProductByIdReq): GetProductByIdRes {
        val result = this.getShopById.execute(
            command = GetShopProductByIdUseCase.Command(
                id = dto.id!!
            )
        )

        return GetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getShopCatalog(dto: GetAllProductsReq): GetAllProductsRes {
        val result = this.getShopCatalog.execute(
            command = GetShopProductsCatalogUseCase.Command(
                filters = dto.filters
            )
        )

        return GetAllProductsMapper.toResponse(
            products = result.products
        )
    }

    override fun getBackofficeById(dto: GetProductByIdReq): GetProductByIdRes {
        val result = this.getBackofficeById.execute(
            command = GetBackofficeProductByIdUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )

        return GetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getBackofficeCatalog(dto: GetAllProductsReq): GetAllProductsRes {
        val result = this.getBackofficeCatalog.execute(
            command = GetBackofficeProductsCatalogUseCase.Command(
                user = dto.user,
                filters = dto.filters
            )
        )

        return GetAllProductsMapper.toResponse(
            products = result.products
        )
    }
}
