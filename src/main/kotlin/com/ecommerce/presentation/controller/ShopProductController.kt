package com.ecommerce.presentation.controller

import com.ecommerce.application.service.ProductServiceI
import com.ecommerce.presentation.dto.product.mapper.ShopGetAllProductsMapper
import com.ecommerce.presentation.dto.product.mapper.ShopGetProductByIdMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shop/products")
class ShopProductController(
    private val service: ProductServiceI
) {

    @GetMapping
    fun shopGetProductById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = ShopGetProductByIdMapper.toRequest(id)
        val response = service.shopGetProductById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun shopGetAllProducts(
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = ShopGetAllProductsMapper.toRequest(categoryId, name, minPrice, maxPrice)
        val response = service.shopGetAllProducts(request)
        return ResponseEntity.ok(response)
    }
}
