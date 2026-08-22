package com.ecommerce.infrastructure.postgres.projections.subcategory

import java.util.Date

interface SubcategoryFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getSlug(): String
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
}
