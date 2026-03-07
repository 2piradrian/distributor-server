package com.ecommerce.domain.repository

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters

interface ProductRepositoryI {
    fun getById(id: String): Product?
    fun getBasicById(id: String): Product?
    fun getPublicById(id: String): Product?
    fun getPublicBasicById(id: String): Product?
    fun getByName(name: String): Product?
    fun getAll(filters: ProductFilters? = null): List<Product>
    fun getAllPublic(filters: ProductFilters? = null): List<Product>
    fun getAllBasic(filters: ProductFilters? = null): List<Product>
    fun getAllPublicBasic(filters: ProductFilters? = null): List<Product>
    fun save(product: Product): Product
    fun update(product: Product): Product
    fun delete(id: String)
}
