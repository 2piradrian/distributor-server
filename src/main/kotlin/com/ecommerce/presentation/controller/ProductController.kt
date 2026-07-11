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

    // === SHOP PATHS ===

    @GetMapping("/shop")
    fun getShopById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetProductByIdMapper.toRequest(null, id)
        val response = this.service.getShopById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/shop/catalog")
    fun getShopCatalog(
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllProductsMapper.toRequest(null, categoryId, name, minPrice, maxPrice)
        val response = this.service.getShopCatalog(request)
        return ResponseEntity.ok(response)
    }

    // === BACKOFFICE PATHS ===

    @GetMapping("/backoffice")
    fun getBackofficeById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetProductByIdMapper.toRequest(user, id)
        val response = this.service.getBackofficeById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/backoffice/catalog")
    fun getBackofficeCatalog(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllProductsMapper.toRequest(user, categoryId, name, minPrice, maxPrice)
        val response = this.service.getBackofficeCatalog(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/backoffice")
    fun create(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateProductMapper.toRequest(user, payload)
        val response = this.service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping("/backoffice")
    fun update(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateProductMapper.toRequest(user, id, payload)
        val response = this.service.update(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/backoffice")
    fun delete(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteProductMapper.toRequest(user, id)
        this.service.delete(request)
        return ResponseEntity.noContent().build<Any>()
    }

}
