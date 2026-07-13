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

    @GetMapping("/detail")
    fun getCategoryById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetCategoryByIdMapper.toRequest(user, id)
        val response = service.getCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun getAllCategories(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = GetAllCategoriesMapper.toRequest(user)
        val response = service.getAllCategories(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateCategoryMapper.toRequest(user, payload)
        val response = service.createCategory(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun updateCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateCategoryMapper.toRequest(user, id, payload)
        val response = service.updateCategory(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun deleteCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteCategoryMapper.toRequest(user, id)
        service.deleteCategory(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
