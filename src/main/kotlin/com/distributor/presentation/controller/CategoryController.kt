package com.distributor.presentation.controller

import com.distributor.application.service.CategoryServiceI
import com.distributor.presentation.dto.category.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(
    private val service: CategoryServiceI
) {

    @PostMapping
    fun create(
        @RequestHeader("Authorization") token: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateCategoryMapper.toRequest(token, payload)
        val response = service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun update(
        @RequestHeader("Authorization") token: String,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateCategoryMapper.toRequest(token, id, payload)
        val response = service.update(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun delete(
        @RequestHeader("Authorization") token: String,
        @RequestParam id: String
    ): ResponseEntity<*> {
        service.delete(token, id)
        return ResponseEntity.noContent().build<Any>()
    }

    @GetMapping
    fun getById(
        @RequestHeader("Authorization") token: String,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetCategoryByIdMapper.toRequest(token, id)
        val response = service.getById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun getAll(
        @RequestHeader("Authorization") token: String
    ): ResponseEntity<*> {
        val request = GetAllCategoriesMapper.toRequest(token)
        val response = service.getAll(request)
        return ResponseEntity.ok(response)
    }
}
