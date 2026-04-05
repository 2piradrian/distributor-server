package com.ecommerce.infrastructure.postgres.projections.category

import java.util.Date

interface CategoryPublicFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getSlug(): String
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
}
