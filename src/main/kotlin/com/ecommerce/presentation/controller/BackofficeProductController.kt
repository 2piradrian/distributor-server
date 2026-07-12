package com.ecommerce.presentation.controller

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
    fun backofficeGetProductById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = BackofficeGetProductByIdMapper.toRequest(user, id)
        val response = service.backofficeGetProductById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun backofficeGetAllProducts(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = BackofficeGetAllProductsMapper.toRequest(user, categoryId, name, minPrice, maxPrice)
        val response = service.backofficeGetAllProducts(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun backofficeCreateProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = BackofficeCreateProductMapper.toRequest(user, payload)
        val response = service.backofficeCreateProduct(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun backofficeUpdateProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = BackofficeUpdateProductMapper.toRequest(user, id, payload)
        val response = service.backofficeUpdateProduct(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    fun backofficeDeleteProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = BackofficeDeleteProductMapper.toRequest(user, id)
        service.backofficeDeleteProduct(request)
        return ResponseEntity.noContent().build<Any>()
    }
}
