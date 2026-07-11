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
    fun getShopById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetCategoryByIdMapper.toRequest(null, id)
        val response = this.service.getShopById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/shop/catalog")
    fun getShopCatalog(): ResponseEntity<*> {
        val request = GetAllCategoriesMapper.toRequest(null)
        val response = service.getShopCatalog(request)
        return ResponseEntity.ok(response)
    }

    // === BACKOFFICE PATHS ===

    @GetMapping("/backoffice")
    fun getBackofficeById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetCategoryByIdMapper.toRequest(user, id)
        val response = this.service.getBackofficeById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/backoffice/catalog")
    fun getBackofficeCatalog(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = GetAllCategoriesMapper.toRequest(user)
        val response = this.service.getBackofficeCatalog(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/backoffice")
    fun create(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateCategoryMapper.toRequest(user, payload)
        val response = this.service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping("/backoffice")
    fun update(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateCategoryMapper.toRequest(user, id, payload)
        val response = this.service.update(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/backoffice")
    fun delete(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteCategoryMapper.toRequest(user, id)
        this.service.delete(request)
        return ResponseEntity.noContent().build<Any>()
    }

}
