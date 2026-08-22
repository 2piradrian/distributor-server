package com.ecommerce.presentation.controller

import com.ecommerce.application.service.SubcategoryServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.subcategory.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/subcategories")
class SubcategoryController(
    private val service: SubcategoryServiceI
) {

    @GetMapping("/detail")
    fun getSubcategoryById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetSubcategoryByIdMapper.toRequest(user, id)
        val response = this.service.getSubcategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun getAllSubcategories(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = GetAllSubcategoriesMapper.toRequest(user)
        val response = this.service.getAllSubcategories(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createSubcategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateSubcategoryMapper.toRequest(user, payload)
        val response = this.service.createSubcategory(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun updateSubcategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateSubcategoryMapper.toRequest(user, id, payload)
        val response = this.service.updateSubcategory(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun deleteSubcategory(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteSubcategoryMapper.toRequest(user, id)
        this.service.deleteSubcategory(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
