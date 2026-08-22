package com.ecommerce.infrastructure.postgres.projections.category

import com.ecommerce.infrastructure.postgres.projections.subcategory.SubcategoryFullProjection
import java.util.Date

interface CategoryPublicFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getSlug(): String
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
    fun getSubcategories(): List<SubcategoryFullProjection>?
}
