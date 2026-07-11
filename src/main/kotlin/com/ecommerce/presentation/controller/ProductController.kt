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
    fun getShopProductById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetShopProductByIdMapper.toRequest(id)
        val response = this.service.getShopProductById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/shop/catalog")
    fun getAllShopProducts(
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllShopProductsMapper.toRequest(categoryId, name, minPrice, maxPrice)
        val response = this.service.getAllShopProducts(request)
        return ResponseEntity.ok(response)
    }

    // === BACKOFFICE PATHS ===

    @GetMapping("/backoffice")
    fun getBackofficeProductById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetBackofficeProductByIdMapper.toRequest(user, id)
        val response = this.service.getBackofficeProductById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/backoffice/catalog")
    fun getAllBackofficeProducts(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllBackofficeProductsMapper.toRequest(user, categoryId, name, minPrice, maxPrice)
        val response = this.service.getAllBackofficeProducts(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/backoffice")
    fun createProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateBackofficeProductMapper.toRequest(user, payload)
        val response = this.service.createProduct(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping("/backoffice")
    fun updateProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateBackofficeProductMapper.toRequest(user, id, payload)
        val response = this.service.updateProduct(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/backoffice")
    fun deleteProduct(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = DeleteBackofficeProductMapper.toRequest(user, id)
        this.service.deleteProduct(request)
        return ResponseEntity.noContent().build<Any>()
    }

}
