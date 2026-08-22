package com.ecommerce.infrastructure.postgres.projections.subcategory

interface SubcategoryBasicProjection {
    fun getId(): String?
    fun getName(): String
    fun getSlug(): String
}
