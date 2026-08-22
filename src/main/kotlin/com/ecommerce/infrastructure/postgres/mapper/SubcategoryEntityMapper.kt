package com.ecommerce.infrastructure.postgres.mapper

import com.ecommerce.infrastructure.postgres.model.SubcategoryModel
import com.ecommerce.infrastructure.postgres.projections.subcategory.SubcategoryBasicProjection
import com.ecommerce.infrastructure.postgres.projections.subcategory.SubcategoryFullProjection
import com.ecommerce.domain.entity.Subcategory
import java.util.Date

object SubcategoryEntityMapper {

    // --- --- --- --- --- --- From Model --- --- --- --- --- --- //

    fun toDomain(model: SubcategoryModel?): Subcategory? {
        return model?.let {
            Subcategory(
                id = it.id,
                name = it.name,
                slug = it.slug,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }

    // --- --- --- --- --- --- From Projections --- --- --- --- --- --- //

    fun toDomain(projection: SubcategoryFullProjection?): Subcategory? {
        return projection?.let {
            Subcategory(
                id = it.getId(),
                name = it.getName(),
                slug = it.getSlug(),
                createdAt = it.getCreatedAt(),
                updatedAt = it.getUpdatedAt()
            )
        }
    }

    fun toDomain(projection: SubcategoryBasicProjection?): Subcategory? {
        return projection?.let {
            Subcategory(
                id = it.getId(),
                name = it.getName(),
                slug = it.getSlug(),
                createdAt = null,
                updatedAt = null
            )
        }
    }

    // --- --- --- --- --- --- To Model --- --- --- --- --- --- //

    fun toModel(domain: Subcategory?): SubcategoryModel? {
        return domain?.let {
            SubcategoryModel().apply {
                id = it.id
                name = it.name
                slug = it.slug
                createdAt = it.createdAt ?: Date()
                updatedAt = it.updatedAt ?: Date()
            }
        }
    }

    // --- --- --- --- --- --- From Lists --- --- --- --- --- --- //

    fun <T> toDomain(source: List<T>?, mapper: (T) -> Subcategory?): List<Subcategory> {
        return source?.mapNotNull { mapper(it) } ?: emptyList()
    }

    fun toDomain(models: List<SubcategoryModel>?): List<Subcategory> =
        models?.mapNotNull { toDomain(it) } ?: emptyList()

    fun toModel(domains: List<Subcategory>?): List<SubcategoryModel> =
        domains?.mapNotNull { toModel(it) } ?: emptyList()
}
