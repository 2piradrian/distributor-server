package com.ecommerce.infrastructure.postgres.projections.product

import com.ecommerce.infrastructure.postgres.projections.category.CategoryBasicProjection
import java.util.Date

interface ProductFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getDescription(): String
    fun getPrice(): Double
    fun getStock(): Int
    fun getCategory(): CategoryBasicProjection?
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
}
