package com.ecommerce.presentation.controller

import com.ecommerce.application.service.CategoryServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.mapper.BackofficeCreateCategoryMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeDeleteCategoryMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeGetAllCategoriesMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeGetCategoryByIdMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeUpdateCategoryMapper
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
        val request = BackofficeGetCategoryByIdMapper.toRequest(user, id)
        val response = service.getBackofficeCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun getAllBackofficeCategories(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = BackofficeGetAllCategoriesMapper.toRequest(user)
        val response = service.getAllBackofficeCategories(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = BackofficeCreateCategoryMapper.toRequest(user, payload)
        val response = service.createCategory(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun updateCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = BackofficeUpdateCategoryMapper.toRequest(user, id, payload)
        val response = service.updateCategory(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun deleteCategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = BackofficeDeleteCategoryMapper.toRequest(user, id)
        service.deleteCategory(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
