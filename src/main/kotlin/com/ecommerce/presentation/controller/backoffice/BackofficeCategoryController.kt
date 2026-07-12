package com.ecommerce.presentation.controller.backoffice

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
    fun getBackofficeCategoryById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetBackofficeCategoryByIdMapper.toRequest(user, id)
        val response = service.getBackofficeCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun getAllBackofficeCategories(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = GetAllBackofficeCategoriesMapper.toRequest(user)
        val response = service.getAllBackofficeCategories(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateBackofficeCategoryMapper.toRequest(user, payload)
        val response = service.createCategory(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun updateCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateBackofficeCategoryMapper.toRequest(user, id, payload)
        val response = service.updateCategory(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun deleteCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteBackofficeCategoryMapper.toRequest(user, id)
        service.deleteCategory(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
