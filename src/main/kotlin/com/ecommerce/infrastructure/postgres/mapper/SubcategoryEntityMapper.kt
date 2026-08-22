package com.ecommerce.infrastructure.postgres.mapper

import com.ecommerce.infrastructure.postgres.model.SubcategoryModel
import com.ecommerce.domain.entity.Subcategory
import java.util.Date

object SubcategoryEntityMapper {

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

    fun toDomain(models: List<SubcategoryModel>?): List<Subcategory> =
        models?.mapNotNull { toDomain(it) } ?: emptyList()

    fun toModel(domains: List<Subcategory>?): List<SubcategoryModel> =
        domains?.mapNotNull { toModel(it) } ?: emptyList()
}
