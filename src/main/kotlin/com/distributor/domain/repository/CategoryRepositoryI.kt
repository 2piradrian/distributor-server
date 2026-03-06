package com.distributor.domain.repository

import com.distributor.domain.entity.Category

interface CategoryRepositoryI {
    fun getById(id: String): Category?
    fun getBasicById(id: String): Category?
    fun getByName(name: String): Category?
    fun getAll(): List<Category>
    fun getAllBasic(): List<Category>
    fun save(category: Category): Category
    fun update(category: Category): Category
    fun delete(id: String)
}
