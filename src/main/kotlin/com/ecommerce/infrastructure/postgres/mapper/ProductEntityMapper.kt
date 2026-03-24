package com.ecommerce.infrastructure.postgres.mapper

import com.ecommerce.domain.entity.Product
import com.ecommerce.infrastructure.postgres.model.ProductModel
import com.ecommerce.infrastructure.postgres.projections.product.ProductBasicProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductFullProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductPublicBasicProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductPublicFullProjection
import java.util.Date

object ProductEntityMapper {

    // --- --- --- --- --- --- From Model --- --- --- --- --- --- //

    fun toDomain(model: ProductModel?): Product? {
        return model?.let {
            Product(
                id = it.id,
                name = it.name,
                description = it.description,
                price = it.price,
                offerPrice = it.offerPrice,
                stock = it.stock,
                category = CategoryEntityMapper.toDomain(it.category),
                mainImage = it.mainImage,
                images = it.images,
                isVisible = it.isVisible,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }

    // --- --- --- --- --- --- From Projections --- --- --- --- --- --- //

    fun toDomain(projection: ProductFullProjection?): Product? {
        return projection?.let {
            Product(
                id = it.getId(),
                name = it.getName(),
                description = it.getDescription(),
                price = it.getPrice(),
                offerPrice = it.getOfferPrice(),
                stock = it.getStock(),
                category = CategoryEntityMapper.toDomain(it.getCategory()),
                mainImage = it.getMainImage(),
                images = it.getImages(),
                isVisible = it.getIsVisible(),
                createdAt = it.getCreatedAt(),
                updatedAt = it.getUpdatedAt()
            )
        }
    }

    fun toDomain(projection: ProductBasicProjection?): Product? {
        return projection?.let {
            Product(
                id = it.getId(),
                name = it.getName(),
                description = "",
                price = it.getPrice(),
                offerPrice = it.getOfferPrice(),
                stock = it.getStock(),
                category = null,
                mainImage = it.getMainImage(),
                images = emptyList(),
                isVisible = it.getIsVisible(),
                createdAt = null,
                updatedAt = null
            )
        }
    }

    fun toDomain(projection: ProductPublicFullProjection?): Product? {
        return projection?.let {
            Product(
                id = it.getId(),
                name = it.getName(),
                description = it.getDescription(),
                price = it.getPrice(),
                offerPrice = it.getOfferPrice(),
                stock = it.getStock(),
                category = CategoryEntityMapper.toDomain(it.getCategory()),
                mainImage = it.getMainImage(),
                images = it.getImages(),
                isVisible = it.getIsVisible(),
                createdAt = it.getCreatedAt(),
                updatedAt = it.getUpdatedAt()
            )
        }
    }

    fun toDomain(projection: ProductPublicBasicProjection?): Product? {
        return projection?.let {
            Product(
                id = it.getId(),
                name = it.getName(),
                description = "",
                price = it.getPrice(),
                offerPrice = it.getOfferPrice(),
                stock = it.getStock(),
                category = null,
                mainImage = it.getMainImage(),
                images = emptyList(),
                isVisible = it.getIsVisible(),
                createdAt = null,
                updatedAt = null
            )
        }
    }

    // --- --- --- --- --- --- To Model --- --- --- --- --- --- //

    fun toModel(domain: Product?): ProductModel? {
        return domain?.let {
            ProductModel().apply {
                id = it.id
                name = it.name
                description = it.description
                price = it.price
                offerPrice = it.offerPrice
                stock = it.stock
                category = CategoryEntityMapper.toModel(it.category)
                mainImage = it.mainImage
                images = it.images
                isVisible = it.isVisible
                createdAt = it.createdAt ?: Date()
                updatedAt = it.updatedAt ?: Date()
            }
        }
    }

    // --- --- --- --- --- --- From Lists --- --- --- --- --- --- //

    fun <T> toDomain(source: List<T>?, mapper: (T) -> Product?): List<Product> {
        return source?.mapNotNull { mapper(it) } ?: emptyList()
    }

    fun toDomain(models: List<ProductModel>?): List<Product> =
        models?.mapNotNull { toDomain(it) } ?: emptyList()

    fun toModel(domains: List<Product>?): List<ProductModel> =
        domains?.mapNotNull { toModel(it) } ?: emptyList()
}
