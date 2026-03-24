package com.ecommerce.infrastructure.postgres.projections.product

interface ProductBasicProjection {
    fun getId(): String?
    fun getName(): String
    fun getPrice(): Double
    fun getOfferPrice(): Double?
    fun getStock(): Int
    fun getMainImage(): String?
    fun getIsVisible(): Boolean
}
