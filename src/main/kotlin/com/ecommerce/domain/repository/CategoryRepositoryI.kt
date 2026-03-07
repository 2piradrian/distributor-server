package com.ecommerce.domain.repository

import com.ecommerce.domain.entity.Category

interface CategoryRepositoryI {
    fun getById(id: String): Category?
    fun getBasicById(id: String): Category?
    fun getPublicById(id: String): Category?
    fun getPublicBasicById(id: String): Category?
    fun getByName(name: String): Category?
    fun getAll(): List<Category>
    fun getAllPublic(): List<Category>
    fun getAllBasic(): List<Category>
    fun getAllPublicBasic(): List<Category>
    fun save(category: Category): Category
    fun update(category: Category): Category
    fun delete(id: String)
}
