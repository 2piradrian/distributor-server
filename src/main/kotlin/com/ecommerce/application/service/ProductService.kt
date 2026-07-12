package com.ecommerce.application.service

import com.ecommerce.application.use_case.product.*
import com.ecommerce.presentation.dto.product.mapper.BackofficeCreateProductMapper
import com.ecommerce.presentation.dto.product.mapper.BackofficeGetProductByIdMapper
import com.ecommerce.presentation.dto.product.mapper.BackofficeUpdateProductMapper
import com.ecommerce.presentation.dto.product.mapper.ShopGetAllProductsMapper
import com.ecommerce.presentation.dto.product.mapper.ShopGetProductByIdMapper
import com.ecommerce.presentation.dto.product.request.BackofficeCreateProductReq
import com.ecommerce.presentation.dto.product.request.BackofficeDeleteProductReq
import com.ecommerce.presentation.dto.product.request.BackofficeGetAllProductsReq
import com.ecommerce.presentation.dto.product.request.BackofficeGetProductByIdReq
import com.ecommerce.presentation.dto.product.request.BackofficeUpdateProductReq
import com.ecommerce.presentation.dto.product.request.ShopGetAllProductsReq
import com.ecommerce.presentation.dto.product.request.ShopGetProductByIdReq
import com.ecommerce.presentation.dto.product.response.BackofficeCreateProductRes
import com.ecommerce.presentation.dto.product.response.BackofficeGetAllProductsRes
import com.ecommerce.presentation.dto.product.response.BackofficeGetProductByIdRes
import com.ecommerce.presentation.dto.product.response.BackofficeUpdateProductRes
import com.ecommerce.presentation.dto.product.response.ShopGetAllProductsRes
import com.ecommerce.presentation.dto.product.response.ShopGetProductByIdRes
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

    override fun createProduct(dto: BackofficeCreateProductReq): BackofficeCreateProductRes {
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

    override fun updateProduct(dto: BackofficeUpdateProductReq): BackofficeUpdateProductRes {
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

    override fun deleteProduct(dto: BackofficeDeleteProductReq) {
        this.delete.execute(
            command = BackofficeDeleteProductUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getShopProductById(dto: ShopGetProductByIdReq): ShopGetProductByIdRes {
        val result = this.getShopById.execute(
            command = ShopGetProductByIdUseCase.Command(
                id = dto.id
            )
        )

        return ShopGetProductByIdMapper.toResponse(
            product = result.product
        )
    }

    override fun getAllShopProducts(dto: ShopGetAllProductsReq): ShopGetAllProductsRes {
        val result = this.getShopCatalog.execute(
            command = ShopGetAllProductsUseCase.Command(
                filters = dto.filters
            )
        )

        return ShopGetAllProductsMapper.toResponse(
            products = result.products
        )
    }

    override fun getBackofficeProductById(dto: BackofficeGetProductByIdReq): BackofficeGetProductByIdRes {
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

    override fun getAllBackofficeProducts(dto: BackofficeGetAllProductsReq): BackofficeGetAllProductsRes {
        val result = this.getBackofficeCatalog.execute(
            command = BackofficeGetAllProductsUseCase.Command(
                user = dto.user,
                filters = dto.filters
            )
        )

        return BackofficeGetAllProductsRes(
            products = result.products
        )
    }
}
