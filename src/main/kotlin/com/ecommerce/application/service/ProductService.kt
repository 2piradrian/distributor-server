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

    /* ==== Use Cases === */
    private val create: BackofficeCreateProductUseCase,
    private val update: BackofficeUpdateProductUseCase,
    private val delete: BackofficeDeleteProductUseCase,
    private val getShopById: ShopGetProductByIdUseCase,
    private val getShopCatalog: ShopGetAllProductsUseCase,
    private val getBackofficeById: BackofficeGetProductByIdUseCase,
    private val getBackofficeCatalog: BackofficeGetAllProductsUseCase

) : ProductServiceI {

    override fun backofficeCreateProduct(dto: BackofficeCreateProductReq): BackofficeCreateProductRes {
        val result = create.execute(
            command = BackofficeCreateProductUseCase.Command(
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

        return BackofficeCreateProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun backofficeUpdateProduct(dto: BackofficeUpdateProductReq): BackofficeUpdateProductRes {
        val result = update.execute(
            command = BackofficeUpdateProductUseCase.Command(
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

        return BackofficeUpdateProductMapper.toResponse(
            id = result.product.id!!
        )
    }

    override fun backofficeDeleteProduct(dto: BackofficeDeleteProductReq) {
        this.delete.execute(
            command = BackofficeDeleteProductUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun shopGetProductById(dto: ShopGetProductByIdReq): ShopGetProductByIdRes {
        val result = this.getShopById.execute(
            command = ShopGetProductByIdUseCase.Command(
                id = dto.id
            )
        )

        return ShopGetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun shopGetAllProducts(dto: ShopGetAllProductsReq): ShopGetAllProductsRes {
        val result = this.getShopCatalog.execute(
            command = ShopGetAllProductsUseCase.Command(
                filters = dto.filters
            )
        )

        return ShopGetAllProductsMapper.toResponse(
            products = result.products
        )
    }

    override fun backofficeGetProductById(dto: BackofficeGetProductByIdReq): BackofficeGetProductByIdRes {
        val result = this.getBackofficeById.execute(
            command = BackofficeGetProductByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return BackofficeGetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun backofficeGetAllProducts(dto: BackofficeGetAllProductsReq): BackofficeGetAllProductsRes {
        val result = this.getBackofficeCatalog.execute(
            command = BackofficeGetAllProductsUseCase.Command(
                user = dto.user,
                filters = dto.filters
            )
        )

        return BackofficeGetAllProductsMapper.toResponse(
            products = result.products
        )
    }
}
