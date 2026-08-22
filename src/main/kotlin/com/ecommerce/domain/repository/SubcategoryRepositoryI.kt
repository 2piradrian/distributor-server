package com.ecommerce.domain.repository

import com.ecommerce.domain.entity.Subcategory

interface SubcategoryRepositoryI {
    fun getById(id: String): Subcategory?
    fun getByName(name: String): Subcategory?
    fun getAll(): List<Subcategory>
    fun save(subcategory: Subcategory): Subcategory
    fun update(subcategory: Subcategory): Subcategory
    fun delete(id: String)
}
