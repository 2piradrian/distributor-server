package com.ecommerce.domain.entity

import java.util.Date

class Product(
    val id: String?,
    var name: String,
    var description: String,
    var price: Double,
    var stock: Int,
    var category: Category?,
    val createdAt: Date?,
    var updatedAt: Date?
) {
    fun update(
        name: String,
        description: String,
        price: Double,
        stock: Int,
        category: Category?
    ) {
        this.name = name
        this.description = description
        this.price = price
        this.stock = stock
        this.category = category
        this.updatedAt = Date()
    }
}
