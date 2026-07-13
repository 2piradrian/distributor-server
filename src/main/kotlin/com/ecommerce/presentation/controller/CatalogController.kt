package com.ecommerce.presentation.controller

import com.ecommerce.application.service.CatalogServiceI
import com.ecommerce.presentation.dto.catalog.mapper.GetCategoryCatalogByIdMapper
import com.ecommerce.presentation.dto.catalog.mapper.GetCategoryCatalogMapper
import com.ecommerce.presentation.dto.catalog.mapper.GetProductCatalogByIdMapper
import com.ecommerce.presentation.dto.catalog.mapper.GetProductCatalogMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/catalog")
class CatalogController(
    private val catalogService: CatalogServiceI
) {

    @GetMapping("/products")
    fun getProductCatalog(
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) minPrice: Double?,
        @RequestParam(required = false) maxPrice: Double?
    ): ResponseEntity<*> {
        val request = GetProductCatalogMapper.toRequest(categoryId, name, minPrice, maxPrice)
        val response = catalogService.getProductCatalog(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/products/detail")
    fun getProductCatalogById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetProductCatalogByIdMapper.toRequest(id)
        val response = catalogService.getProductCatalogById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/categories")
    fun getCategoryCatalog(): ResponseEntity<*> {
        val request = GetCategoryCatalogMapper.toRequest()
        val response = catalogService.getCategoryCatalog(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/categories/detail")
    fun getCategoryCatalogById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetCategoryCatalogByIdMapper.toRequest(id)
        val response = catalogService.getCategoryCatalogById(request)
        return ResponseEntity.ok(response)
    }
}
