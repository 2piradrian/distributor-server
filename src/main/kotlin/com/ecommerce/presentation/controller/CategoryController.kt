package com.ecommerce.presentation.controller

import com.ecommerce.application.service.CategoryServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(
    private val service: CategoryServiceI
) {

    // === SHOP PATHS ===

    @GetMapping("/shop")
    fun getShopCategoryById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetShopCategoryByIdMapper.toRequest(id)
        val response = this.service.getShopCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/shop/catalog")
    fun getAllShopCategories(): ResponseEntity<*> {
        val request = GetAllShopCategoriesMapper.toRequest()
        val response = this.service.getAllShopCategories(request)
        return ResponseEntity.ok(response)
    }

    // === BACKOFFICE PATHS ===

    @GetMapping("/backoffice")
    fun getBackofficeCategoryById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetBackofficeCategoryByIdMapper.toRequest(user, id)
        val response = this.service.getBackofficeCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/backoffice/catalog")
    fun getAllBackofficeCategories(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = GetAllBackofficeCategoriesMapper.toRequest(user)
        val response = this.service.getAllBackofficeCategories(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/backoffice")
    fun createCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateBackofficeCategoryMapper.toRequest(user, payload)
        val response = this.service.createCategory(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping("/backoffice")
    fun updateCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateBackofficeCategoryMapper.toRequest(user, id, payload)
        val response = this.service.updateCategory(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/backoffice")
    fun deleteCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteBackofficeCategoryMapper.toRequest(user, id)
        this.service.deleteCategory(request)
        return ResponseEntity.noContent().build<Any>()
    }

}
