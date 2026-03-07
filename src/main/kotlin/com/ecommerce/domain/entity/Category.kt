package com.ecommerce.domain.entity

import java.util.Date

class Category(
    val id: String?,
    var name: String,
    val createdAt: Date?,
    var updatedAt: Date?
) {
    fun update(name: String) {
        this.name = name
        this.updatedAt = Date()
    }
}
