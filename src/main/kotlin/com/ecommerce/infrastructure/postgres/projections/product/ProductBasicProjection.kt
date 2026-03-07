package com.ecommerce.infrastructure.postgres.projections.product

interface ProductBasicProjection {
    fun getId(): String?
    fun getName(): String
    fun getPrice(): Double
    fun getStock(): Int
}
