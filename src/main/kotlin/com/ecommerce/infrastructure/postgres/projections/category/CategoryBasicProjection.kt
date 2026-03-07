package com.ecommerce.infrastructure.postgres.projections.category

interface CategoryBasicProjection {
    fun getId(): String?
    fun getName(): String
}
