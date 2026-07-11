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

    override fun createProduct(dto: CreateBackofficeProductReq): CreateBackofficeProductRes {
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

        return CreateBackofficeProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun updateProduct(dto: UpdateBackofficeProductReq): UpdateBackofficeProductRes {
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

        return UpdateBackofficeProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun deleteProduct(dto: DeleteBackofficeProductReq) {
        this.delete.execute(
            command = DeleteProductUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getShopProductById(dto: GetShopProductByIdReq): GetShopProductByIdRes {
        val result = this.getShopById.execute(
            command = GetShopProductByIdUseCase.Command(
                id = dto.id
            )
        )

        return GetShopProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getAllShopProducts(dto: GetAllShopProductsReq): GetAllShopProductsRes {
        val result = this.getShopCatalog.execute(
            command = GetShopProductsCatalogUseCase.Command(
                filters = dto.filters
            )
        )

        return GetAllShopProductsMapper.toResponse(
            products = result.products
        )
    }

    override fun getBackofficeProductById(dto: GetBackofficeProductByIdReq): GetBackofficeProductByIdRes {
        val result = this.getBackofficeById.execute(
            command = GetBackofficeProductByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return GetBackofficeProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getAllBackofficeProducts(dto: GetAllBackofficeProductsReq): GetAllBackofficeProductsRes {
        val result = this.getBackofficeCatalog.execute(
            command = GetBackofficeProductsCatalogUseCase.Command(
                user = dto.user,
                filters = dto.filters
            )
        )

        return GetAllBackofficeProductsMapper.toResponse(
            products = result.products
        )
    }
}
