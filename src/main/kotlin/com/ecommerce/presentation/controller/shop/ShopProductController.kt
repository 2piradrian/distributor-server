package com.ecommerce.presentation.controller.shop

import com.ecommerce.application.service.ProductServiceI
import com.ecommerce.presentation.dto.product.mapper.GetAllShopProductsMapper
import com.ecommerce.presentation.dto.product.mapper.GetShopProductByIdMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shop/products")
class ShopProductController(
    private val service: ProductServiceI
) {

    @GetMapping
    fun getShopProductById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetShopProductByIdMapper.toRequest(id)
        val response = service.getShopProductById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun getAllShopProducts(
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetAllShopProductsMapper.toRequest(categoryId, name, minPrice, maxPrice)
        val response = service.getAllShopProducts(request)
        return ResponseEntity.ok(response)
    }
}
