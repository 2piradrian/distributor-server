package com.ecommerce.presentation.controller

import com.ecommerce.application.service.ProductServiceI
import com.ecommerce.presentation.dto.product.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val service: ProductServiceI
) {

    @PostMapping
    fun create(
        @RequestHeader("Authorization") token: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateProductMapper.toRequest(token, payload)
        val response = service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun update(
        @RequestHeader("Authorization") token: String,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateProductMapper.toRequest(token, id, payload)
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
        val request = GetProductByIdMapper.toRequest(token, id)
        val response = service.getById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun getAll(
        @RequestHeader("Authorization") token: String,
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllProductsMapper.toRequest(
            token = token,
            categoryId = categoryId,
            name = name,
            minPrice = minPrice,
            maxPrice = maxPrice
        )
        val response = service.getAll(request)
        return ResponseEntity.ok(response)
    }
}
