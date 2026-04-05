package com.ecommerce.infrastructure.postgres.mapper

import com.ecommerce.infrastructure.postgres.model.CategoryModel
import com.ecommerce.infrastructure.postgres.projections.category.CategoryBasicProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryFullProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryPublicBasicProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryPublicFullProjection
import com.ecommerce.domain.entity.Category
import java.util.Date

object CategoryEntityMapper {

    // --- --- --- --- --- --- From Model --- --- --- --- --- --- //

    fun toDomain(model: CategoryModel?): Category? {
        return model?.let {
            Category(
                id = it.id,
                name = it.name,
                slug = it.slug,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }

    // --- --- --- --- --- --- From Projections --- --- --- --- --- --- //

    fun toDomain(projection: CategoryFullProjection?): Category? {
        return projection?.let {
            Category(
                id = it.getId(),
                name = it.getName(),
                slug = it.getSlug(),
                createdAt = it.getCreatedAt(),
                updatedAt = it.getUpdatedAt()
            )
        }
    }

    fun toDomain(projection: CategoryBasicProjection?): Category? {
        return projection?.let {
            Category(
                id = it.getId(),
                name = it.getName(),
                slug = it.getSlug(),
                createdAt = null,
                updatedAt = null
            )
        }
    }

    fun toDomain(projection: CategoryPublicFullProjection?): Category? {
        return projection?.let {
            Category(
                id = it.getId(),
                name = it.getName(),
                slug = it.getSlug(),
                createdAt = it.getCreatedAt(),
                updatedAt = it.getUpdatedAt()
            )
        }
    }

    fun toDomain(projection: CategoryPublicBasicProjection?): Category? {
        return projection?.let {
            Category(
                id = it.getId(),
                name = it.getName(),
                slug = it.getSlug(),
                createdAt = null,
                updatedAt = null
            )
        }
    }

    // --- --- --- --- --- --- To Model --- --- --- --- --- --- //

    fun toModel(domain: Category?): CategoryModel? {
        return domain?.let {
            CategoryModel().apply {
                id = it.id
                name = it.name
                slug = it.slug
                createdAt = it.createdAt ?: Date()
                updatedAt = it.updatedAt ?: Date()
            }
        }
    }

    // --- --- --- --- --- --- From Lists --- --- --- --- --- --- //

    fun <T> toDomain(source: List<T>?, mapper: (T) -> Category?): List<Category> {
        return source?.mapNotNull { mapper(it) } ?: emptyList()
    }

    fun toDomain(models: List<CategoryModel>?): List<Category> =
        models?.mapNotNull { toDomain(it) } ?: emptyList()

    fun toModel(domains: List<Category>?): List<CategoryModel> =
        domains?.mapNotNull { toModel(it) } ?: emptyList()

}
