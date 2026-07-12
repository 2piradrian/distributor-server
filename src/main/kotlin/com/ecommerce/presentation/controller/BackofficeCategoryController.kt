package com.ecommerce.presentation.controller

import com.ecommerce.application.service.CategoryServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/backoffice/categories")
class BackofficeCategoryController(
    private val service: CategoryServiceI
) {

    @GetMapping
    fun backofficeGetCategoryById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = BackofficeGetCategoryByIdMapper.toRequest(user, id)
        val response = service.backofficeGetCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun backofficeGetAllCategories(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = BackofficeGetAllCategoriesMapper.toRequest(user)
        val response = service.backofficeGetAllCategories(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun backofficeCreateCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = BackofficeCreateCategoryMapper.toRequest(user, payload)
        val response = service.backofficeCreateCategory(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun backofficeUpdateCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = BackofficeUpdateCategoryMapper.toRequest(user, id, payload)
        val response = service.backofficeUpdateCategory(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun backofficeDeleteCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = BackofficeDeleteCategoryMapper.toRequest(user, id)
        service.backofficeDeleteCategory(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
