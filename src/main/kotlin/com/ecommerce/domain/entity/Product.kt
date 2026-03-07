package com.ecommerce.domain.entity

import java.util.Date

class Product(
    val id: String?,
    var name: String,
    var description: String,
    var price: Double,
    var stock: Int,
    var category: Category?,
    var mainImage: String?,
    var images: List<String>,
    var isVisible: Boolean,
    val createdAt: Date?,
    var updatedAt: Date?
) {
    fun update(
        name: String,
        description: String,
        price: Double,
        stock: Int,
        category: Category?,
        mainImage: String?,
        images: List<String>,
        isVisible: Boolean
    ) {
        this.name = name
        this.description = description
        this.price = price
        this.stock = stock
        this.category = category
        this.mainImage = mainImage
        this.images = images
        this.isVisible = isVisible
        this.updatedAt = Date()
    }
}
