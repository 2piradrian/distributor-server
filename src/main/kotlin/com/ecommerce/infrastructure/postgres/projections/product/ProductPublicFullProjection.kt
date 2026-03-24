package com.ecommerce.infrastructure.postgres.projections.product

import com.ecommerce.infrastructure.postgres.projections.category.CategoryPublicBasicProjection
import java.util.Date

interface ProductPublicFullProjection {
    fun getId(): String?
    fun getName(): String
    fun getDescription(): String
    fun getPrice(): Double
    fun getOfferPrice(): Double?
    fun getStock(): Int
    fun getCategory(): CategoryPublicBasicProjection?
    fun getMainImage(): String?
    fun getImages(): List<String>
    fun getIsVisible(): Boolean
    fun getCreatedAt(): Date
    fun getUpdatedAt(): Date
}
