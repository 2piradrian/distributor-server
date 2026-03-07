package com.ecommerce.infrastructure.postgres.projections.category

import java.util.Date

interface CategoryFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
}
