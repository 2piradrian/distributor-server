package com.ecommerce.infrastructure.postgres.projections.category

import com.ecommerce.infrastructure.postgres.model.SubcategoryModel
import java.util.Date

interface CategoryFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getSlug(): String
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
    fun getSubcategories(): List<SubcategoryModel>?
}
