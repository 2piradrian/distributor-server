package com.ecommerce.presentation.controller

import com.ecommerce.application.service.ProductServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val service: ProductServiceI
) {

    @GetMapping
    fun getById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetProductByIdMapper.toRequest(user, id)
        val response = service.getById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun getAll(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllProductsMapper.toRequest(user, categoryId, name, minPrice, maxPrice)
        val response = service.getAll(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun create(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateProductMapper.toRequest(user, payload)
        val response = service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun update(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateProductMapper.toRequest(user, id, payload)
        val response = service.update(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun delete(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteProductMapper.toRequest(user, id)
        service.delete(request)
        return ResponseEntity.noContent().build<Any>()
    }

}
