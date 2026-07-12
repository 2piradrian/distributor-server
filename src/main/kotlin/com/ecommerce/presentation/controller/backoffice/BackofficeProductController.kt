package com.ecommerce.presentation.controller.backoffice

import com.ecommerce.application.service.ProductServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.product.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/backoffice/products")
class BackofficeProductController(
    private val service: ProductServiceI
) {

    @GetMapping
    fun getBackofficeProductById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetBackofficeProductByIdMapper.toRequest(user, id)
        val response = service.getBackofficeProductById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun getAllBackofficeProducts(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllBackofficeProductsMapper.toRequest(user, categoryId, name, minPrice, maxPrice)
        val response = service.getAllBackofficeProducts(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateBackofficeProductMapper.toRequest(user, payload)
        val response = service.createProduct(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun updateProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateBackofficeProductMapper.toRequest(user, id, payload)
        val response = service.updateProduct(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun deleteProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteBackofficeProductMapper.toRequest(user, id)
        service.deleteProduct(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
