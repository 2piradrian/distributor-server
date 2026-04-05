package com.ecommerce.domain.entity

import java.util.Date

class Category(
    val id: String?,
    var name: String,
    var slug: String,
    val createdAt: Date?,
    var updatedAt: Date?
) {
    fun update(name: String, slug: String) {
        this.name = name
        this.slug = slug
        this.updatedAt = Date()
    }
}
