package com.ecommerce.infrastructure.postgres.projections.category

interface CategoryPublicBasicProjection {
    fun getId(): String?
    fun getName(): String
}
